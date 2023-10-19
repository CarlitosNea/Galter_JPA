
const linkCalculadora = document.getElementById("link_calculadora");
const modal1 = document.getElementById("modal1");
linkCalculadora.addEventListener("click", function (event) {
    event.preventDefault();
    modal1.style.display = "block";
});

const closeBtn = document.querySelector(".close-modal");
const modal = document.querySelector("#modal1");
closeBtn.addEventListener("click", function () {
    modal.style.display = "none";
});

$(document).ready(function(){
    let listaProd = document.querySelector('#lista_prod')
    listaProd.innerHTML = ''
    $.ajax({
        url: "http://localhost:8080/listarProductos",
        type: "GET",
        datatype: "JSON",
        success: function(respuesta) {
            console.log(respuesta)
            Object.values(respuesta).forEach(Producto => {
                listaProd.innerHTML += '<option value="' +Producto["codi_prod"] +'">'+Producto["codi_prod"] +'</option>';
            });
        }
    });

        

    $('#calcular').on('click', function() {
        let codi_prod = $('#lista_prod').val()
        let cant_piezas = $('#cant_piezas').val()
        /* let codi_mate = $('#codi_mate')
        let cant_mate = $('#cant_mate')
        let time_pedido = $('#time_pedido')
        let precio_pedido = $('#precio_pedido') */
        console.log(codi_prod)
        console.log(cant_piezas)
        $.ajax({
            url: "http://localhost:8080/calculadora/"+codi_prod+"/"+cant_piezas,
            type: "GET",
            datatype: "JSON",
            success: function (res) {
                console.log(res)
                $('#codi_mate').text(res[0]);
                $('#cant_mate').text(res[1]);
                $('#time_pedido').text(res[2]);
                $('#precio_pedido').text(res[3]);
            }
        })
        

    })

})