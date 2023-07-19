$(document).ready(function(){

    let listaProv = document.querySelector('#prov_input_novo')
        listaProv.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarProveedores",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Proveedor => {
                    listaProv.innerHTML += '<option value="' +Proveedor["nombre_proveedor"] +'">'+Proveedor["nombre_proveedor"] +'</option>';
                });
            }
        });

    let listaProv2 = document.querySelector('#prov_input_act')
        listaProv2.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarProveedores",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Proveedor => {
                    listaProv2.innerHTML += '<option value="' +Proveedor["nombre_proveedor"] +'">'+Proveedor["nombre_proveedor"] +'</option>';
                });
            }
        });

    
        let tabla = $('#tabla_listar');
        $.ajax({
            url: "http://localhost:8080/listarMaterial",
            type : "GET",
            dataType: "JSON",
            success: function(res){
                console.log(res);
                tabla.empty(); // Limpiamos la tabla antes de agregar los datos
                //encabezado
                let encabezado = $('<tr></tr>');
                encabezado.append('<th>Codigo</th>');
                encabezado.append('<th>Nombre</th>');
                encabezado.append('<th>Cantidad</th>');
                encabezado.append('<th>Proveedor</th>');
                
                tabla.append(encabezado);
                // Agregamos los datos a cada fila de la tabla
                for (let i = 0; i < res.length; i++) {
                    let fila = $('<tr></tr>');
                    fila.append('<td>' + res[i].codi_mate + '</td>');
                    fila.append('<td>' + res[i].nomb_mate + '</td>');
                    fila.append('<td>' + res[i].cant_mate + '</td>');
                    fila.append('<td>' + res[i].proveedor + '</td>');
                    tabla.append(fila);
                }
            }
        })
    

    $('#buscar').on('click', function(){
        let dato = $('#id_input_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarMaterialCodigo/"+dato,
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
            codi_mate: $('#codigo_input_novo').val(),
            nomb_mate: $('#nombre_input_novo').val(),
            cant_mate: $('#cant_input_novo').val(),
            proveedor: $('#prov_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/insertarProveedor",
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
            codi_mate: $('#codigo_input_act').val(),
            nomb_mate: $('#nombre_input_act').val(),
            cant_mate: $('#cant_input_act').val(),
            proveedor: $('#prov_input_act').val(),
        };
        let datosEnvio = JSON.stringify(datos);
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizarMaterial",
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
            url: "http://localhost:8080/eliminarMaterial/" + dato,
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