$(document).ready(function(){
    $('#listar').on('click', function(){
        let tabla = $('#tabla_listar');
        $.ajax({
            url: "http://localhost:8080/listarProveedores",
            type : "GET",
            dataType: "JSON",
            success: function(res){
                console.log(res);
                tabla.empty(); // Limpiamos la tabla antes de agregar los datos
                
                // Agregamos los datos a cada fila de la tabla
                for (let i = 0; i < res.length; i++) {
                    let fila = $('<tr></tr>');
                    fila.append('<th scope="row">' + "Nombre proveedor:" + '</th>');
                    fila.append('<td>' + res[i].nombre_proveedor + '</td>');
                    tabla.append(fila);
                }
            }
        })
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

    $('#enviar').on('click', function(){
        let datos = {
            nombre_proveedor: $('#nombre_input_novo').val(),
        }
        let datosEnvio = JSON.stringify(datos)
        console.log(datos)
        console.log(datosEnvio)
        $.ajax({
            url: "http://localhost:8080/insertarProveedor",
            type: "POST",
            data: datosEnvio,
            contentType: "application/JSON",
            datatype: JSON,
            success: function(respuesta){
                alert(respuesta)
            }
        })
    })


    $('#eliminar').on('click', function(){
        let dato = $('#nombre_input_delete').val();
        $.ajax({
            url: "http://localhost:8080/eliminarProveedor/"+dato,
            type: "DELETE",
            dataType: "JSON",
            success: function(respuesta){
                if(respuesta)
                    alert("eliminado exitosamente")
                else
                    alert("no existe el dato")
            }})
        })

})