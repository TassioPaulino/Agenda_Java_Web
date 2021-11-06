document.getElementById("btn_1").onclick = sanitizarDados;

function sanitizarDados(){
    let nome = frm_contato.nome.value;
    let fone = frm_contato.fone.value;
    if(nome === ""){
        alert("Atenção! O nome é obrigatório.");
        frm_contato.nome.focus();
    } else if(fone === "") {
        alert("Atenção! O fone é obrigatório.");
        frm_contato.fone.focus();
    } else {
        document.forms["frm_contato"].submit();
    }
}

function confirmarEdicao(){
    if(confirm("Deseja realmente editar o contato?")){
        document.forms["frm_editor"].submit();
    } else {
        window.location.href="main";
    }
}

function confirmarExclusao(id){
    if(confirm("Deseja realmente deletar o contato de ID " +id+ " ?")){
        window.location.href="delete?idcon=" + id;
    } else {
        window.location.href="main";
    }
}


