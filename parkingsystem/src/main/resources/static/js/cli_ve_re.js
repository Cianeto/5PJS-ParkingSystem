// INSERIR VEICULO (
document.getElementById("veiculoForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const formData = new FormData(this);

  var regex = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}";
  var placa = formData.get("placa");

  if (placa.match(regex)) {
    fetch("/insertVeiculo", {
      method: "POST",
      body: formData,
    })
      .then((response) => {
        console.log(response);
        window.location.reload();
      })
      .catch((error) =>
        console.error(
          "There has been a problem with your fetch operation:",
          error
        )
      );
  } else {
    alert("Placa inválida. Verifique o número digitado.");
    document.getElementById("placa").focus();
  }
});
// )

// DELETAR VEICULO (
function deleteVeiculo(id) {
  fetch("/deleteVeiculo/" + id, { method: "DELETE" }).then((response) => {
    console.log(response);
    window.location.reload();
  });
}
// )

// INSERIR RESERVA (
function reservar(id) {
  console.log(id);
  fetch("/insertReserva?veiculoId=" + id, { method: "POST" })
    .then((response) => {
      if (response.ok) {
        console.log("Reserva feita com sucesso.");
        window.location.reload(); // Recarrega a página após a reserva
      } else {
        console.error("Erro ao fazer reserva.");
      }
    })
    .catch((error) =>
      console.error("Houve um problema com a operação fetch:", error)
    );
}
// )

// FINALIZAR RESERVA (
function finalizar(reservaStr) {
  const reserva = reservaStr
    .slice(reservaStr.indexOf("(") + 1, reservaStr.length - 1)
    .split(", ")
    .reduce((acc, current) => {
      const [key, value] = current.split("=");
      acc[key] = value;
      return acc;
    }, {});
  var status = reserva.reservaStatus;
  console.log(status);
  if (status == "FINALIZADO") {
    return;
  }
  fetch("/confirmarPagamento?reservaId=" + reserva.reservaId, {
    method: "POST",
  })
    .then((response) => {
      if (response.ok) {
        console.log("Reserva finalizada com sucesso.");
        window.location.reload();
      } else {
        console.error("Erro ao finalizar reserva.");
      }
    })
    .catch((error) =>
      console.error("Houve um problema com a operação fetch:", error)
    );
}
// )

// ADICIONAR COMENTARIO (
function showCommentForm(reservaId) {
  // Exibe o formulário
  document.getElementById("commentDiv").style.display = "block";
  // Armazena o reservaId para uso posterior
  document.getElementById("commentDiv").dataset.reservaId = reservaId;
}

function closeForm() {
  document.getElementById("commentDiv").style.display = "none";
}

function submitComment() {
  const comment = document.getElementById("comment").value;
  const reservaId = document.getElementById("commentDiv").dataset.reservaId;

  fetch(`/veiculo/${reservaId}/${comment}`, {
    method: "PUT",
  })
    .then((response) => {
      if (response.ok) {
        //alert("Comentário adicionado com sucesso!");
        document.getElementById("commentDiv").style.display = "none";
        window.location.reload();
      } else {
        alert("Erro ao adicionar comentário.");
      }
    })
    .catch((error) => console.error("Erro:", error));
}
// )

// DELETAR RESERVA (
function deleteReserva(id) {
  fetch("/deleteReserva/" + id, { method: "DELETE" }).then((response) => {
    console.log(response);
    window.location.reload();
  });
}
// )
