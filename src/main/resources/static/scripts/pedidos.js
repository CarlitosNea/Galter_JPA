$(document).ready(function(){
    
    let tabla = $('#tabla_listar');
    $.ajax({
        url: "http://localhost:8080/listarPedido",
        type : "GET",
        dataType: "JSON",
        success: function(res){
            console.log(res);
            tabla.empty(); // Limpiamos la tabla antes de agregar los datos
            //encabezado
            let encabezado = $('<tr></tr>');
            encabezado.append('<th>Id</th>');
            encabezado.append('<th>Cliente</th>');
            encabezado.append('<th>Producto</th>');
            encabezado.append('<th>Usuario</th>');
            encabezado.append('<th>Tiempo Produccion (h)</th>');
            encabezado.append('<th>Fecha Encargo</th>');
            encabezado.append('<th>Fecha Entrega</th>');
            
            tabla.append(encabezado);
            // Agregamos los datos a cada fila de la tabla
            for (let i = 0; i < res.length; i++) {
                let fila = $('<tr></tr>');
                fila.append('<td>' + res[i].id_pedido + '</td>');
                fila.append('<td>' + res[i].cliente_ped + '</td>');
                fila.append('<td>' + res[i].producto_ped + '</td>');
                fila.append('<td>' + res[i].usuario_ped + '</td>');
                fila.append('<td>' + res[i].tiempo_pedido + '</td>');
                fila.append('<td>' + res[i].fecha_encargo + '</td>');
                fila.append('<td>' + res[i].fecha_entrega + '</td>');
                tabla.append(fila);
            }
        }
    })

    let listaClientes = document.querySelector('#cli_input_novo')
        listaClientes.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarCliente",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Cliente => {
                    listaClientes.innerHTML += '<option value="' +Cliente["id_cliente"] +'">'+Cliente["nombre_cliente"] +'</option>';
                });
            }
        });

    let listaClientes1 = document.querySelector('#cli_input_act')
        listaClientes1.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarCliente",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Cliente => {
                    listaClientes1.innerHTML += '<option value="' +Cliente["id_cliente"] +'">'+Cliente["nombre_cliente"] +'</option>';
                });
            }
        });


    let listaProd = document.querySelector('#prod_input_novo')
        listaProd.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarProductos",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Producto => {
                    listaProd.innerHTML += '<option value="' +Producto["codi_prod"] +'">'+Producto["nomb_prod"] +'</option>';
                });
            }
        });

        let listaProd1 = document.querySelector('#prod_input_act')
        listaProd1.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarProductos",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Producto => {
                    listaProd1.innerHTML += '<option value="' +Producto["codi_prod"] +'">'+Producto["nomb_prod"] +'</option>';
                });
            }
        });


    let listaUsu = document.querySelector('#usu_input_novo')
        listaUsu.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarUsuarios",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Usuario => {
                    listaUsu.innerHTML += '<option value="' +Usuario["codi_usuario"] +'">'+Usuario["nombre_usuario"] +'</option>';
                });
            }
        });

    
    let listaUsu1 = document.querySelector('#usu_input_act')
        listaUsu1.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarUsuarios",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Usuario => {
                    listaUsu1.innerHTML += '<option value="' +Usuario["codi_usuario"] +'">'+Usuario["nombre_usuario"] +'</option>';
                });
            }
        });

    let listaPed = document.querySelector('#codigo_input_novo')
        listaPed.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarPedidos",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Pedido => {
                    listaPed.innerHTML += '<option value="' +Pedido["id_pedido"] +'">'+Pedido["id_pedido"] +'</option>';
                });
            }
        });

    

    $('#buscar').on('click', function(){
        let dato = $('#id_input_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarPedidoCodigo/"+dato,
            type: "GET",
            dataType: 'json',
            success: function(respuesta){
                alert(dato+" si se encuentra")
            },
            error: function(){
                alert(dato+" no se encuentra")
            }
        });
    });

    $('#enviar').on('click', function() {
        let datos = {
            id_pedido: 0,
            fecha_encargo: $('#encargo_input_novo').val(),
            fecha_entrega: $('#entrega_input_novo').val(),
            tiempo_pedido: $('#time_input_novo').val(),
        }
        let datosEnvio = JSON.stringify(datos)
        let cliente = $('#cli_input_novo').val()
        let producto = $('#prod_input_novo').val()
        let usuario = $('#usu_input_novo').val()

        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/insertarPedido/"+cliente+"/"+producto+"/"+usuario,
            type: "POST",
            data: datosEnvio,
            contentType: "application/JSON",
            dataType: "json", 
            success: function(respuesta) {
                alert(respuesta)
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    });


    $('#actualizar').on('click', function() {
        let datos = {
            id_pedido: 0,
            fecha_encargo: $('#encargo_input_act').val(),
            fecha_entrega: $('#entrega_input_act').val(),
            tiempo_pedido: $('#time_input_act').val(),
        }
        let datosEnvio = JSON.stringify(datos)
        let cliente = $('#cli_input_act').val()
        let producto = $('#prod_input_act').val()
        let usuario = $('#usu_input_act').val()
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizarPedido/"+cliente+"/"+producto+"/"+usuario,
            type: "PUT",
            data: datosEnvio,
            contentType: "application/JSON", // Corregido: el tipo de contenido debe ser "application/json"
            dataType: "json", // Corregido: dataType en minúscula
            success: function(respuesta) {
                alert(respuesta)
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    });

})