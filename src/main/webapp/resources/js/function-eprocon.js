//$(document).ready(function () {
//    ajustaPaddingConteudo();
//    ajustaTopo();
//    var status = document.getElementById("mostra-cabecalho").value;
//    if (status == 'false') {
//        $("#cabecalho").hide();
//        $("#topo").hide();
//        aumentarConteudoTopo();
//    }
//    var status = document.getElementById("mostra-rodape").value;
//    if (status == 'false') {
//        $("#div-rodape").hide();
//        $("#divIniciar").hide();
//        aumentarConteudoRodape();
//    }
//    $(".maiusculo").keypress(function () {
//        var el = $(this);
//        setTimeout(function () {
//            var text = $(el).val();
//            el.val(text.toUpperCase());
//        }, 100);
//    });
//
//    $(".numero").keypress(function () {
//        var el = $(this);
//        setTimeout(function () {
//            var text = $(el).val();
//            el.val(text.replace(/\D/g, ""));
//        }, 100);
//    });
//
//    upperText();
//    function upperText() {
//        $(".maiusculo").bind('paste', function (e) {
//            var el = $(this);
//            setTimeout(function () {
//                var text = $(el).val();
//                el.val(text.toUpperCase());
//            }, 100);
//        });
//        $(".maiusculo").keypress(function () {
//            var el = $(this);
//            setTimeout(function () {
//                var text = $(el).val();
//                el.val(text.toUpperCase());
//            }, 100);
//        });
//    }
//
//    $(".exercicio").mask("9999");
//});
//
//$(window).load(function () {
//    $("#menu").hide();
//    $("#menu").width('300px');
//    document.getElementById("mostra-menu").value = 'false';
//
//});

//
function atribuirStyles(elemento, styles) {
    for (var s in styles) {
        elemento.style[s] = styles[s];
    }
}

function redimensionarDialog(id) {
    //    window.scrollTo(0, 0);
    console.log(id);
    var info = document.getElementById(id);
    var div = document.getElementById('div-info-mensagens');
    var style = info.style;
    var hTotal = window.innerHeight;
    var wTotal = window.innerWidth;
    style.top = '100px';
    style.left = '15px';
    style.right = '25px';
    style.bottom = '25px';
    style.width = ''.concat(wTotal -= 50, 'px');
    style.height = ''.concat(hTotal -= 200, 'px');
    div.style.height = ''.concat(hTotal -= 60, 'px');
    atribuirStyles(info, style);
}

function redimensionarLadosDialog(id) {

    var info = document.getElementById(id);
    var style = info.style;
    var wTotal = window.innerWidth;
    var diferencaW = wTotal * 0.2;
    style.left = diferencaW / 2 + "px";
    style.minWidth = (wTotal - diferencaW) + "px";
}

function aumentarConteudoTopo() {
    document.getElementById("conteudo").style.paddingTop = '10px';
}
function diminuirConteudoTopo() {
    document.getElementById("conteudo").style.paddingTop = '125px';
}
function aumentarConteudoRodape() {
    document.getElementById("conteudo").style.paddingBottom = '10px';
}
function diminuirConteudoRodape() {
    document.getElementById("conteudo").style.paddingBottom = '45px';
}

//function toggleCabecalho() {
//    if (document.getElementById("mostra-cabecalho").value == 'false') {
//        document.getElementById("mostra-cabecalho").value = 'true';
//        diminuirConteudoTopo()
//    } else {
//        document.getElementById("mostra-cabecalho").value = 'false';
//        aumentarConteudoTopo();
//    }
//    $("#cabecalho").slideToggle("fast");
//    $("#topo").slideToggle("fast");
//}

function toggleRodape() {
    if (document.getElementById("mostra-rodape").value == 'false') {
        document.getElementById("mostra-rodape").value = 'true';
        diminuirConteudoRodape();
    } else {
        document.getElementById("mostra-rodape").value = 'false';
        aumentarConteudoRodape();
    }
    $("#div-rodape").slideToggle("fast");
    $("#divIniciar").slideToggle("fast");
}

// Ouvidor de retorno à pagina
isOuvidorAtivo = false;
$(window).focus(function () {
    if (!isOuvidorAtivo)
        return;
    func();
});

function ativarOuvidor(f) {
    isOuvidorAtivo = true;
    func = f;
}

function desativarOuvidor() {
    isOuvidorAtivo = false;
}

function abrirFecharMenu() {
    if (document.getElementById("mostra-menu").value == 'false') {
        abrirMenu();
    } else {
        fecharMenu();
    }
}

function abrirMenu() {
    var hTotal = window.innerHeight;
    document.getElementById("menu").style.height = ''.concat(hTotal, 'px');
    $('#menu').css('display', 'block')
    document.getElementById("mostra-menu").value = 'true';
    $(this).toggleClass('pesquisa-menu');
}

function fecharMenu() {
    if (document.getElementById("mostra-menu").value == 'true') {
        $('#menu').css('display', 'none')
        document.getElementById("mostra-menu").value = 'false';
    }
}

function setaFoco(arg) {
    document.getElementById(arg).focus();
}

function selecionarConteudoDe(arg) {
    document.getElementById(arg).select();
}

function copiaValor(de, para) {
    var conteudo = de.value;
    document.getElementById(para).value = conteudo;
}

function TocarSom(obj) {
    var sound = document.getElementById(obj);
    sound.Play();
}

PrimeFaces.locales['pt_BR'] = {
    closeText: 'Fechar',
    prevText: 'Anterior',
    nextText: 'Próximo',
    currentText: 'Começo',
    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthNamesShort: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
    dayNamesMin: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
    weekHeader: 'Semana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Só Horas',
    timeText: 'Tempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    currentText: 'Data Atual',
    ampm: false,
    month: 'Mês',
    week: 'Semana',
    day: 'Dia',
    allDayText: 'Todo Dia'
}

function mascaraMonetaria(arg) {
    //Set up the NumberMasks
    var separadorDecimal = ",";
    var separadorMilhar = ".";

    var formato = new NumberParser(2, separadorDecimal, separadorMilhar, true);
    formato.currencySymbol = "R$";
    formato.useCurrency = true;
    formato.allowNegative = false;
    formato.currencyInside = true;

    if (arg.className.indexOf('mascaraMonetaria') == -1) {
        var mascaraMonetariaFinal = new NumberMask(formato, arg, 20);
        mascaraMonetariaFinal.leftToRight = true;
        arg.setAttribute('autocomplete', 'off');
        arg.className += ' mascaraMonetaria';
    }
}

function mascaraPonto(arg) {
    //Set up the NumberMasks
    var separadorDecimal = ",";
    var separadorMilhar = ".";

    var formato = new NumberParser(2, separadorDecimal, separadorMilhar, true);
    formato.useCurrency = false;
    formato.allowNegative = false;
    formato.currencyInside = true;

    if (arg.className.indexOf('mascaraMonetaria') == -1) {
        var mascaraMonetariaFinal = new NumberMask(formato, arg, 20);
        mascaraMonetariaFinal.leftToRight = true;
        arg.setAttribute('autocomplete', 'off');
        arg.className += ' mascaraMonetaria';
    }
}

function mascaraPonto4Casas(arg) {
    //Set up the NumberMasks
    var separadorDecimal = ",";
    var separadorMilhar = ".";

    var formato = new NumberParser(4, separadorDecimal, separadorMilhar, true);
    formato.useCurrency = false;
    formato.allowNegative = false;
    formato.currencyInside = true;

    if (arg.className.indexOf('mascaraMonetaria') == -1) {
        var mascaraMonetariaFinal = new NumberMask(formato, arg, 20);
        mascaraMonetariaFinal.leftToRight = true;
        arg.setAttribute('autocomplete', 'off');
        arg.className += ' mascaraMonetaria';
    }
}

function mascara(o, f) {
    v_obj = o
    v_fun = f
    setTimeout("execmascara()", 1)
}

function execmascara() {
    v_obj.value = v_fun(v_obj.value)
}

function mascaraSufixo(o, f, sufixo) {
    v_obj = o
    v_fun = f
    setTimeout("execSufixo(" + sufixo + ")", 1)
}

function execSufixo(sufixo) {
    v_obj.value = v_fun(v_obj.value, sufixo)
}

function porcentagem(v) {
    v = v.replace(/%/, "")
    valor = v

    v = valor + "%"
    return v
}

function sufixo(v, sufixo) {
    v = v.replace(sufixo, "")
    valor = v

    v = valor + sufixo;
    return v
}

function soNumeros(v) {
    return v.replace(/\D/g, "")
}
function Data(v) {
    v = v.replace(/\D/g, "")
    v = v.replace(/(\d{2})(\d)/, "$1/$2")
    v = v.replace(/(\d{2})(\d)/, "$1/$2")
    return v

}

function ajustaTopo() {
    var pull = $('#pull');
    var menu = $('nav ul');

    $(pull).on('click', function (e) {
        e.preventDefault();
        menu.slideToggle();
    });

    $(window).resize(function () {
        var w = $(window).width();
        if (w > 320 && menu.is(':hidden')) {
            menu.removeAttr('style');
        }
        ajustaPaddingConteudo();
    });
}
function ajustaPaddingConteudo() {
    var tamanhoTopo = $('#superior').height();
    tamanhoTopo += 10;
    $('#conteudo').css('padding-top', tamanhoTopo + 'px')
}


function getCookie(c_name) {
    var i, x, y, ARRcookies = document.cookie.split(";");
    for (i = 0; i < ARRcookies.length; i++) {
        x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
        y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
        x = x.replace(/^\s+|\s+$/g, "");
        if (x == c_name) {
            return unescape(y);
        }
    }
}

function setCookie(c_name, value, exdays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
    document.cookie = c_name + "=" + c_value;
}

function checkCookie() {
    var username = getCookie("username");
    if (username != null && username != "") {
        alert("Welcome again " + username);
    }
    else {
        username = prompt("Please enter your name:", "");
        if (username != null && username != "") {
            setCookie("username", username, 365);
        }
    }
}
function limitador(field, maxlimit) {
    if (field.value.length > maxlimit) {
        field.value = field.value.substring(0, maxlimit);
    }
}


function mcep(v) {
    v = v.replace(/\D/g, "")                    //Remove tudo o que não é dígito
    v = v.replace(/^(\d{5})(\d)/, "$1-$2")         //Esse é tão fácil que não merece explicações
    return v
}
function mtel(v) {
    v = v.replace(/\D/g, "");             //Remove tudo o que não é dígito
    v = v.replace(/^(\d{2})(\d)/g, "($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v = v.replace(/(\d)(\d{4})$/, "$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}
function cnpj(v) {
    v = v.replace(/\D/g, "")                           //Remove tudo o que não é dígito
    v = v.replace(/^(\d{2})(\d)/, "$1.$2")             //Coloca ponto entre o segundo e o terceiro dígitos
    v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3") //Coloca ponto entre o quinto e o sexto dígitos
    v = v.replace(/\.(\d{3})(\d)/, ".$1/$2")           //Coloca uma barra entre o oitavo e o nono dígitos
    v = v.replace(/(\d{4})(\d)/, "$1-$2")              //Coloca um hífen depois do bloco de quatro dígitos
    return v
}
function mcpf(v) {
    v = v.replace(/\D/g, "")                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{3})(\d)/, "$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
    v = v.replace(/(\d{3})(\d)/, "$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
    //de novo (para o segundo bloco de números)
    v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
    return v
}
function mdata(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{2})(\d)/, "$1/$2");
    v = v.replace(/(\d{2})(\d)/, "$1/$2");

    v = v.replace(/(\d{2})(\d{2})$/, "$1$2");
    if (v.toString().length > 10) {
        v = v.replace(v, v.toString().substring(0, 10));
    }
    return v;
}
function mtempo(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{1})(\d{2})(\d{2})/, "$1:$2.$3");
    return v;
}
function mhora(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{2})(\d)/, "$1h$2");
    return v;
}
function mrg(v) {
    v = v.replace(/\D/g, "");                                      //Remove tudo o que não é dígito
    v = v.replace(/(\d)(\d{7})$/, "$1.$2");    //Coloca o . antes dos últimos 3 dígitos, e antes do verificador
    v = v.replace(/(\d)(\d{4})$/, "$1.$2");    //Coloca o . antes dos últimos 3 dígitos, e antes do verificador
    v = v.replace(/(\d)(\d)$/, "$1-$2");               //Coloca o - antes do último dígito
    return v;
}
function mnum(v) {
    v = v.replace(/\D/g, "");                                      //Remove tudo o que não é dígito
    return v;
}
function mvalor(v) {
    v = v.replace(/\D/g, "");//Remove tudo o que não é dígito
    v = v.replace(/(\d)(\d{8})$/, "$1.$2");//coloca o ponto dos milhões
    v = v.replace(/(\d)(\d{5})$/, "$1.$2");//coloca o ponto dos milhares

    v = v.replace(/(\d)(\d{2})$/, "$1,$2");//coloca a virgula antes dos 2 últimos dígitos
    return v;
}
function porcentagemSomenteNumero(v) {
    v = soNumeros(v);
    if (parseInt(v.toString()) > parseInt('100')) {
        v = v.replace(v, '100');
    }
    v = porcentagem(v);
    return v;
}
function mDataHora(v) {
    v = soNumeros(v);

    v = v.replace(/(\d{2})(\d)/, "$1/$2");
    v = v.replace(/(\d{2})(\d)/, "$1/$2");

    v = v.replace(/(\d{2})(\d{2})$/, "$1$2");
    v = v.replace(/(\d{4})(\d{2})/, "$1 $2:");
    v = v.replace(/(\d{2})(\d{2})(\d{4})(\d{2})(\d{2})/, "$1/$2/$3 $4:$5");

    if (v.toString().length > 16) {
        v = v.replace(v, v.toString().substring(0, 16));
    }
    return v;
}

function keyUpLimparCampo(campoOrigem, idCampoDestino) {
    var split = campoOrigem.id.toString().split(':');
    var idOrigem = split[split.length - 1];

    if (campoOrigem.value.toString().trim().length == 0 || campoOrigem.value == '' || campoOrigem.value == 'undefined') {
        var idPanel = campoOrigem.id.replace(idOrigem, idCampoDestino);
        var panel = document.getElementById(idPanel);
        panel.value = '';
    }
}
function keyUpEsconderCampo(campoOrigem, idCampoDestino) {
    var split = campoOrigem.id.toString().split(':');
    var idOrigem = split[split.length - 1];

    if (campoOrigem.value.toString().trim().length == 0 || campoOrigem.value == '' || campoOrigem.value == 'undefined') {
        var idPanel = campoOrigem.id.replace(idOrigem, idCampoDestino);
        var panel = document.getElementById(idPanel);
        panel.style.display = 'none';
    }
}
function keyUpDesabilidarCampo(campoOrigem, idCampoDestino) {
    var split = campoOrigem.id.toString().split(':');
    var idOrigem = split[split.length - 1];

    if (campoOrigem.value.toString().trim().length == 0 || campoOrigem.value == '' || campoOrigem.value == 'undefined') {
        var idPanel = campoOrigem.id.replace(idOrigem, idCampoDestino);
        var panel = document.getElementById(idPanel);
        panel.disabled = true;
    }
}
function keyUpLimparEsconderDesabilidarCampo(campoOrigem, idCampoDestino, limpar, esconder, desabilidar) {
    var split = campoOrigem.id.toString().split(':');
    var idOrigem = split[split.length - 1];

    if (campoOrigem.value.toString().trim().length == 0 || campoOrigem.value == '' || campoOrigem.value == 'undefined') {
        var idPanel = campoOrigem.id.replace(idOrigem, idCampoDestino);
        var panel = document.getElementById(idPanel);
        if (limpar == true) {
            panel.value = '';
        }
        if (esconder == true) {
            panel.style.display = 'none';
        }
        if (desabilidar == true) {
            panel.disabled = true;
        }
    }
}
function mMesAno(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{2})(\d)/, "$1/$2");
    v = v.replace(/(\d{4})(\d)/, "$1/$2");

    v = v.replace(/(\d{2})(\d{4})$/, "$1$2");
    if (v.toString().length > 7) {
        v = v.replace(v, v.toString().substring(0, 7));
    }
    return v;
}