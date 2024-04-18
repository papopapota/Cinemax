$(document).on("click", "#btnagregar", function(){
    $("#txtnompelicula").val("");
    $("#txtdescpelicula").val("");
    $("#hddpelicod").val("0");
    $("#modalpelicula").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnompelicula").val($(this).attr("data-pelititulo"));
    $("#txtdescpelicula").val($(this).attr("data-pelidescrip"));
    $("#hddpelicod").val($(this).attr("data-pelicod"));
    $("#modalpelicula").modal("show");
});
