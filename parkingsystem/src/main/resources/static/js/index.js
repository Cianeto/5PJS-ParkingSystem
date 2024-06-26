// INSERIR CLIENTE (
document.getElementById("clienteForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const formData = new FormData(this);

  var cpf = formData.get("cpf");

  if (validarCPF(cpf)) {
    fetch("/insertCliente", {
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
    alert("CPF inválido. Verifique o número digitado.");
    document.getElementById("cpf").focus();
  }
});

function validarCPF(cpf) {
  cpf = cpf.replace(/\D+/g, "");
  if (cpf.length !== 11) return false;

  let soma = 0;
  let resto;
  if (/^(\d)\1{10}$/.test(cpf)) return false;

  for (let i = 1; i <= 9; i++)
    soma += parseInt(cpf.substring(i - 1, i)) * (11 - i);
  resto = (soma * 10) % 11;
  if (resto === 10 || resto === 11) resto = 0;
  if (resto !== parseInt(cpf.substring(9, 10))) return false;

  soma = 0;
  for (let i = 1; i <= 10; i++)
    soma += parseInt(cpf.substring(i - 1, i)) * (12 - i);
  resto = (soma * 10) % 11;
  if (resto === 10 || resto === 11) resto = 0;
  if (resto !== parseInt(cpf.substring(10, 11))) return false;

  return true;
}
// )

// DELETAR CLIENTE (
function deleteCliente(id) {
  fetch("/deleteCliente/" + id, { method: "DELETE" })
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
}
// )

// ATUALIZAR CLIENTE (
document
  .getElementById("attClienteForm")
  .addEventListener("submit", function (e) {
    e.preventDefault();
    const formData = new FormData(this);
    fetch("/updateCliente", {
      method: "PUT",
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
  });

function openAndPopulateForm(clienteStr) {
  const cliente = clienteStr
    .slice(clienteStr.indexOf("(") + 1, clienteStr.length - 1)
    .split(", ")
    .reduce((acc, current) => {
      const [key, value] = current.split("=");
      acc[key] = value;
      return acc;
    }, {});

  document.getElementById("attClienteId").value = cliente.clienteId;
  document.getElementById("attNome").value = cliente.nome;
  document.getElementById("attCpf").value = cliente.cpf;
  document.getElementById("attTelefone").value = cliente.telefone;

  document.getElementById("attClienteDiv").style.display = "block";
}

function closeForm() {
  document.getElementById("attClienteDiv").style.display = "none";
}
// )
