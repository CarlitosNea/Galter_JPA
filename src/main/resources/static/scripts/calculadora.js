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
        alert(codi_prod)
        alert(cant_piezas)
        

    })




})