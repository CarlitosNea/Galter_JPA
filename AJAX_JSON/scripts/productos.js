$(document).ready(function(){
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

        let listaMat = document.querySelector('#mat_input_novo')
        listaMat.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarMaterial",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Material => {
                    listaMat.innerHTML += '<option value="' +Material["codi_mate"] +'">'+Material["nomb_mate"] +'</option>';
                });
            }
        });

        let listaMat1 = document.querySelector('#mat_input_act')
        listaMat1.innerHTML = ''
        $.ajax({
            url: "http://localhost:8080/listarMaterial",
            type: "GET",
            datatype: "JSON",
            success: function(respuesta) {
                console.log(respuesta)
                Object.values(respuesta).forEach(Material => {
                    listaMat1.innerHTML += '<option value="' +Material["codi_mate"] +'">'+Material["nomb_mate"] +'</option>';
                });
            }
        });




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
            long_prod: $('#long_input_novo').val(),
            nomb_prod: $('#nombre_input_novo').val(),
            prec_prod: $('#precio_input_novo').val(),
            tiempo_prod: $('#time_input_novo').val(),
        }
        let datosEnvio = JSON.stringify(datos)
        let material_prod = $('#mat_input_novo option:selected').val()
        console.log(datos)
        console.log(datosEnvio)
        $.ajax({
            url: "http://localhost:8080/insertarProd/"+material_prod,
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
            codi_prod: $('#codigo_input_novo').val(),
            nomb_prod: $('#nombre_input_novo').val(),
            tiempo_prod: $('#time_input_novo').val(),
            long_prod: $('#long_input_novo').val(),
            prec_prod: $('#precio_input_novo').val(),
        };
        let datosEnvio = JSON.stringify(datos)
        let material_prod = $('#mat_input_novo').val()
        console.log(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizarProducto"+material_prod,
            type: "PUT",
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