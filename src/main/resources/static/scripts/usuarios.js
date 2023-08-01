$(document).ready(function(){
        let tabla = $('#tabla_listar');
        $.ajax({
            url: "http://localhost:8080/listarUsuarios",
            type : "GET",
            dataType: "JSON",
            success: function(res){
                console.log(res);
                tabla.empty(); // Limpiamos la tabla antes de agregar los datos
                //encabezado
                let encabezado = $('<tr></tr>');
                encabezado.append('<th>Codigo</th>');
                encabezado.append('<th>Nombre</th>');
                encabezado.append('<th>Correo</th>');
                encabezado.append('<th>Contraseña</th>');
                encabezado.append('<th>Tipo</th>');
                
                tabla.append(encabezado);
                // Agregamos los datos a cada fila de la tabla
                for (let i = 0; i < res.length; i++) {
                    let fila = $('<tr></tr>');
                    fila.append('<td>' + res[i].codi_usuario + '</td>');
                    fila.append('<td>' + res[i].nombre_usuario + '</td>');
                    fila.append('<td>' + res[i].correo_usuario + '</td>');
                    fila.append('<td>' + res[i].pass_usuario + '</td>');
                    fila.append('<td>' + res[i].tipo_usuario + '</td>');
                    tabla.append(fila);
                }
            }
        })
    

    $('#buscar').on('click', function(){
        let dato = $('#id_input_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarUsuario/"+dato,
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
            correo_usuario: $('#email_input_novo').val(),
            nombre_usuario: $('#nombre_input_novo').val(),
            pass_usuario: $('#pass_input_novo').val(),
            tipo_usuario: $('#type_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/insertarUsusario",
            type: "POST",
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


    $('#actualizar').on('click', function() {
        let datos = {
            codi_usuario: $('#codigo_input_act').val(),
            correo_usuario: $('#email_input_act').val(),
            nombre_usuario: $('#nombre_input_act').val(),
            pass_usuario: $('#pass_input_act').val(),
            tipo_usuario: $('#type_input_act').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizarUsuario",
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


    $('#eliminar').on('click', function() {
        let dato = $('#id_input_delete').val();
        $.ajax({
            url: "http://localhost:8080/eliminarUsuario/" + dato,
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
// commit de prueba con rama