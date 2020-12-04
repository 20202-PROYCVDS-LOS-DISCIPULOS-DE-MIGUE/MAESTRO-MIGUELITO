function exportTableToExcel (tableID, nombreSalida = '')
{
    var tablaSeleccionada = document.getElementById(tableID).outerHTML.replace(/ /g, '%20');
    var archivo = document.createElement("a");

    document.body.appendChild(archivo);
    
    nombreSalida = nombreSalida?nombreSalida+'.xls':'excel_data.xls';
    
    if (navigator.msSaveOrOpenBlob) {
        var lineas = new Blob(['\ufeff', tablaSeleccionada], {type: 'application/vnd.ms-excel'});
        navigator.msSaveOrOpenBlob( lineas, nombreSalida);
    } else {
        archivo.href = 'data:' + 'application/vnd.ms-excel' + ', ' + tablaSeleccionada;
        archivo.download = nombreSalida;
        archivo.click();
    }
}