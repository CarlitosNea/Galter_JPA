$(document).ready(function(){
    $('#listar').on('click', function(){
        let tabla = $('#tabla_listar');
        $.ajax({
            url: "http://localhost:8080/listarCliente",
            type : "GET",
            dataType: "JSON",
            success: function(res){
                console.log(res);
                tabla.empty(); // Limpiamos la tabla antes de agregar los datos
                //encabezado
                let encabezado = $('<tr></tr>');
                encabezado.append('<th>Id</th>');
                encabezado.append('<th>Nombre</th>');
                encabezado.append('<th>Telefono</th>');
                encabezado.append('<th>Representante</th>');
                encabezado.append('<th>Direccion</th>');
                
                tabla.append(encabezado);
                // Agregamos los datos a cada fila de la tabla
                for (let i = 0; i < res.length; i++) {
                    let fila = $('<tr></tr>');
                    fila.append('<td>' + res[i].id_cliente + '</td>');
                    fila.append('<td>' + res[i].nombre_cliente + '</td>');
                    fila.append('<td>' + res[i].telefono_cliente + '</td>');
                    fila.append('<td>' + res[i].representante_cliente + '</td>');
                    fila.append('<td>' + res[i].direccion + '</td>');
                    tabla.append(fila);
                }
            }
        })
    })

    $('#buscar').on('click', function(){
        let dato = $('#id_input_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarCliente/"+dato,
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
            codi_usuario: $('#codigo_input_novo').val(),
            nombre_cliente: $('#nombre_input_novo').val(),
            telefono_cliente: $('#telefono_input_novo').val(),
            representante_cliente: $('#rep_input_novo').val(),
            direccion: $('#direccion_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/insertarCliente",
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
            codi_usuario: $('#codigo_input_act').val(),
            nombre_cliente: $('#nombre_input_act').val(),
            telefono_cliente: $('#telefono_input_act').val(),
            representante_cliente: $('#rep_input_act').val(),
            direccion: $('#direccion_input_act').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizarCliente",
            type: "POST",
            data: datosEnvio,
            contentType: "application/json",
            dataType: "json", 
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
            url: "http://localhost:8080/eliminarCliente/" + dato,
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