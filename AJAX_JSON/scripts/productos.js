$(document).ready(function(){
    $('#listar').on('click', function(){
        let tabla = $('#tabla_listar');
        $.ajax({
            url: "http://localhost:8080/listarProductos",
            type : "GET",
            dataType: "JSON",
            success: function(res){
                console.log(res);
                tabla.empty(); // Limpiamos la tabla antes de agregar los datos
                //encabezado
                let encabezado = $('<tr></tr>');
                encabezado.append('<th>Codigo</th>');
                encabezado.append('<th>Nombre</th>');
                encabezado.append('<th>Tiempo (s)</th>');
                encabezado.append('<th>Longitud</th>');
                encabezado.append('<th>Material</th>');
                encabezado.append('<th>Precio</th>');
                
                
                tabla.append(encabezado);
                // Agregamos los datos a cada fila de la tabla
                for (let i = 0; i < res.length; i++) {
                    let fila = $('<tr></tr>');
                    fila.append('<td>' + res[i].codi_prod + '</td>');
                    fila.append('<td>' + res[i].nomb_prod + '</td>');
                    fila.append('<td>' + res[i].tiempo_prod + '</td>');
                    fila.append('<td>' + res[i].long_prod + '</td>');
                    fila.append('<td>' + res[i].material_prod + '</td>');
                    fila.append('<td>' + res[i].prec_prod + '</td>');
                    tabla.append(fila);
                }
            }
        })
    })

    $('#buscar').on('click', function(){
        let dato = $('#id_input_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarProductoCodigo/"+dato,
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
            codi_prod: $('#codigo_input_novo').val(),
            nomb_prod: $('#nombre_input_novo').val(),
            tiempo_prod: $('#time_input_novo').val(),
            long_prod: $('#long_input_novo').val(),
            material_prod: $('#mat_input_novo').val(),
            prec_prod: $('#precio_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/insertarProd",
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
            codi_prod: $('#codigo_input_novo').val(),
            nomb_prod: $('#nombre_input_novo').val(),
            tiempo_prod: $('#time_input_novo').val(),
            long_prod: $('#long_input_novo').val(),
            material_prod: $('#mat_input_novo').val(),
            prec_prod: $('#precio_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizarProducto",
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


    $('#eliminar').on('click', function() {
        let dato = $('#id_input_delete').val();
        $.ajax({
            url: "http://localhost:8080/eliminarProducto/" + dato,
            type: "DELETE",
            dataType: "json", // Corregido: dataType en minúscula
                success: function(respuesta) {
                    if (respuesta) {
                        alert("Eliminado exitosamente");
                    } else {
                        alert("No existe el dato");
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log(textStatus, errorThrown);
                }
        });
    });

})