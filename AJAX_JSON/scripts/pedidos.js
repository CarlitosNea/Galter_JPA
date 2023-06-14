$(document).ready(function(){
    $('#listar').on('click', function(){
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
                    fila.append('<td>' + res[i].cliente + '</td>');
                    fila.append('<td>' + res[i].producto + '</td>');
                    fila.append('<td>' + res[i].usuario + '</td>');
                    fila.append('<td>' + res[i].tiempo_pedido + '</td>');
                    fila.append('<td>' + res[i].fecha_encargo + '</td>');
                    fila.append('<td>' + res[i].fecha_entrega + '</td>');
                    tabla.append(fila);
                }
            }
        })
    })

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
            cliente: $('#cli_input_novo').val(),
            producto: $('#prod_input_novo').val(),
            usuario: $('#usu_input_novo').val(),
            tiempo_pedido: $('#time_input_novo').val(),
            fecha_encargo: $('#encargo_input_novo').val(),
            fecha_entrega: $('#entrega_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/insertarPedido",
            type: "POST",
            data: datosEnvio,
            contentType: "application/json", // Corregido: el tipo de contenido debe ser "application/json"
            dataType: "json", // Corregido: dataType en minúscula
            success: function(respuesta) {
                if (respuesta) {
                    alert("Registrado exitosamente");
                } else {
                    alert("error");
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    });


    $('#actualizar').on('click', function() {
        let datos = {
            id_pedido: $('#codigo_input_act').val(),
            cliente: $('#cli_input_act').val(),
            producto: $('#prod_input_act').val(),
            usuario: $('#usu_input_act').val(),
            tiempo_pedido: $('#time_input_act').val(),
            fecha_encargo: $('#encargo_input_act').val(),
            fecha_entrega: $('#entrega_input_act').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizarPedido",
            type: "POST",
            data: datosEnvio,
            contentType: "application/json", // Corregido: el tipo de contenido debe ser "application/json"
            dataType: "json", // Corregido: dataType en minúscula
            success: function(respuesta) {
                if (respuesta) {
                    alert("Actualizado exitosamente");
                } else {
                    alert("error");
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    });

})