$(document).ready(function(){
        let tabla = $('#tabla_listar');
        $.ajax({
            url: "http://localhost:8080/listarProveedores",
            type : "GET",
            dataType: "JSON",
            success: function(res){
                console.log(res);
                tabla.empty(); // Limpiamos la tabla antes de agregar los datos
                //encabezado
                let encabezado = $('<tr></tr>');
                encabezado.append('<th>Nombre proveedor</th>');
                encabezado.append('<th>Telefono</th>');
                tabla.append(encabezado);
                // Agregamos los datos a cada fila de la tabla
                for (let i = 0; i < res.length; i++) {
                    let fila = $('<tr></tr>');
                    fila.append('<td>' + res[i].nombre_proveedor + '</td>');
                    fila.append('<td>' + res[i].telefono_proveedor + '</td>');
                    tabla.append(fila);
                }
            }
        })

    $('#buscar').on('click', function(){
        let dato = $('#nombre_input_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarProveedor/"+dato,
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
            nombre_proveedor: $('#nombre_input_novo').val(),
            telefono_proveedor: $('#telefono_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/insertarProveedor",
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


    $('#eliminar').on('click', function() {
        let dato = $('#nombre_input_delete').val();
        $.ajax({
            url: "http://localhost:8080/eliminarProveedor/" + dato,
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