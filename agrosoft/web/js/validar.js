/* 
 * funciones de te4clas con javascript
 * permitir numeros (numeros(e))
 * permitir solo letras y espacios sololetras(e)
 * (e): Parametro de entrada caracter
 * que determina la tecla presionada 
 */
//definicion de una funcion 
function numeros (e){
    tecla=(document.all)? e.keyCode:e.which;
    /*capturar el codigo de la tecla e.keyCode
     * con el codigo  de la tecla e.wich;
     */
    if(tecla==8)return true;//tecla de retroceso
    if(tecla==44)return true;//diferenciar decimales 
    if(tecla==48)return true;//0
    if(tecla==49)return true;//1
    if(tecla==50)return true;//2
    if(tecla==51)return true;//3
    if(tecla==52)return true;//4
    if(tecla==53)return true;//5
    if(tecla==54)return true;//6
    if(tecla==55)return true;//7
    if(tecla==56)return true;//8
    if(tecla==57)return true;//9
    patron=/1/;
    te=String.fromCharCode(tecla);
    return patron.test(te);
    
    
}//fin de la funcion.
function sololetras(e){
    key=e.keyCode||e.which;
    tecla=String.fromCharCode(key).toLowerCase();
    letras="áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales=[8,37,39,46];
    tecla_especial=false;
    for(var i in especiales){
        if(key==especiales[i]){
            tecla_especial=true;
            break;
            
        }//fin si
    }//fin for
    
    if(letras.indexOf(tecla)==-1 && !tecla_especial){
        
        return false;
    }
}//fin sololetras

