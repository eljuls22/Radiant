package mx.itson.radiant.negocio;

/**
 * The type Curp.
 */
public class Curp {
    /**
     * Generar curp string.
     *
     * @param nombre          the nombre
     * @param apellidoPaterno the apellido paterno
     * @param apellidoMaterno the apellido materno
     * @param dia             the dia
     * @param mes             the mes
     * @param anio            the anio
     * @param genero          the genero
     * @param estado          the estado
     *
     * @return the string
     */
    public String generarCurp(String nombre, String apellidoPaterno, String apellidoMaterno, String dia, String mes, String anio, String genero, String estado) {

        //Variables para almacenar los datos de la CURP
        String primerLetraPrimerApellido = "";
        String primerVocalInternaPrimerApellido = "";
        String primerLetraSegundoApellido = "";
        String primerLetraNombre = "";
        String primerConsonanteInternaPrimerApellido = "";
        String primerConsonanteInternaSegundoApellido = "";
        String primerConsonanteInternaNombre = "";

        //Convertimos los parametros a mayusculas
        nombre = nombre.toUpperCase();
        apellidoPaterno = apellidoPaterno.toUpperCase();
        apellidoMaterno = apellidoMaterno.toUpperCase();

        //Limpiamos nombre, apellido paterno y apellido materno de espacios en blanco
        nombre = nombre.trim();
        apellidoPaterno = apellidoPaterno.trim();
        apellidoMaterno = apellidoMaterno.trim();

        //Limpiamos nombre, apellido paterno y apellido materno de acentos
        nombre = nombre.replace("Á", "A")
                .replace("É", "E")
                .replace("Í", "I")
                .replace("Ó", "O")
                .replace("Ú", "U")
                .replace("Ñ", "N");
        apellidoPaterno = apellidoPaterno.replace("Á", "A")
                .replace("É", "E")
                .replace("Í", "I")
                .replace("Ó", "O")
                .replace("Ú", "U")
                .replace("Ñ", "N");
        apellidoMaterno = apellidoMaterno.replace("Á", "A")
                .replace("É", "E")
                .replace("Í", "I")
                .replace("Ó", "O")
                .replace("Ú", "U")
                .replace("Ñ", "N");

        //Primera letra y la primera vocal interna del primer apellido.
        char[] apePaterno = apellidoPaterno.toCharArray();
        for (int i = 0; i < apePaterno.length; i++) {
            if (i == 0) {
                primerLetraPrimerApellido = String.valueOf(apePaterno[i]);
            }
            if (i > 0) {
                if (apePaterno[i] == 'A' || apePaterno[i] == 'E' || apePaterno[i] == 'I' || apePaterno[i] == 'O' || apePaterno[i] == 'U') {
                    primerVocalInternaPrimerApellido = String.valueOf(apePaterno[i]);
                    break;
                }
            }
        }

        //Primera letra del segundo apellido. En caso de no tener segundo apellido, se utiliza la X.
        if (apellidoMaterno.length() > 0) {
            char[] apeMaterno = apellidoMaterno.toCharArray();
            primerLetraSegundoApellido = String.valueOf(apeMaterno[0]);
        } else {
            primerLetraSegundoApellido = "X";
        }

        //Primera letra del nombre de pila. En nombres compuestos que comiencen con José o María, se tomará en cuenta la primera letra del segundo nombre.
        char[] nom = nombre.toCharArray();
        if (String.valueOf(nom[0]).equals("J") && String.valueOf(nom[1]).equals("O") && String.valueOf(nom[2]).equals("S") && String.valueOf(nom[3]).equals("E") || String.valueOf(nom[0]).equals("M") && String.valueOf(nom[1]).equals("A") && String.valueOf(nom[2]).equals("R") && String.valueOf(nom[3]).equals("I") && String.valueOf(nom[4]).equals("A")) {
            String[] nombres = nombre.split(" ");
            char[] nombre2 = nombres[1].toCharArray();
            primerLetraNombre = String.valueOf(nombre2[0]);
        } else {
            char[] nombre1 = nombre.toCharArray();
            primerLetraNombre = String.valueOf(nombre1[0]);
        }

        //Fecha de nacimiento sin espacios en orden de año, mes y día; ejemplo: 010425 (2001, abril 25).

        char[] anioChar = anio.toCharArray();
        String anioCorto = "";
        for (int i = 2; i < anioChar.length; i++) {
            anioCorto += anioChar[i];
        }

        if (mes.length() == 1) {
            mes = "0" + mes;
        }

        if (dia.length() == 1) {
            dia = "0" + dia;
        }

        String fechaNacimiento = anioCorto + mes + dia;

        //Letra del sexo o género: H para hombre y M para mujer.
        if (genero.equals("Hombre")) {
            genero = "H";
        } else {
            genero = "M";
        }

        //Dos letras correspondientes a la entidad de nacimiento
        switch (estado) {
            case "Aguascalientes":
                estado = "AS";
                break;
            case "Baja California":
                estado = "BC";
                break;
            case "Baja California Sur":
                estado = "BS";
                break;
            case "Campeche":
                estado = "CC";
                break;
            case "Coahuila":
                estado = "CL";
                break;
            case "Colima":
                estado = "CM";
                break;
            case "Chiapas":
                estado = "CS";
                break;
            case "Chihuahua":
                estado = "CH";
                break;
            case "Distrito Federal":
                estado = "DF";
                break;
            case "Durango":
                estado = "DG";
                break;
            case "Guanajuato":
                estado = "GT";
                break;
            case "Guerrero":
                estado = "GR";
                break;
            case "Hidalgo":
                estado = "HG";
                break;
            case "Jalisco":
                estado = "JC";
                break;
            case "México":
                estado = "MC";
                break;
            case "Michoacán":
                estado = "MN";
                break;
            case "Morelos":
                estado = "MS";
                break;
            case "Nayarit":
                estado = "NT";
                break;
            case "Nuevo León":
                estado = "NL";
                break;
            case "Oaxaca":
                estado = "OC";
                break;
            case "Puebla":
                estado = "PL";
                break;
            case "Querétaro":
                estado = "QT";
                break;
            case "Quintana Roo":
                estado = "QR";
                break;
            case "San Luis Potosí":
                estado = "SP";
                break;
            case "Sinaloa":
                estado = "SL";
                break;
            case "Sonora":
                estado = "SR";
                break;
            case "Tabasco":
                estado = "TC";
                break;
            case "Tamaulipas":
                estado = "TS";
                break;
            case "Tlaxcala":
                estado = "TL";
                break;
            case "Veracruz":
                estado = "VZ";
                break;
            case "Yucatán":
                estado = "YN";
                break;
            case "Zacatecas":
                estado = "ZS";
                break;
            case "Nacido en el Extranjero":
                estado = "NA";
                break;
        }

        //Primera consonante interna (no inicial) del primer apellido.
        for (int i = 1; i < apePaterno.length; i++) {
            if (apePaterno[i] != 'A' && apePaterno[i] != 'E' && apePaterno[i] != 'I' && apePaterno[i] != 'O' && apePaterno[i] != 'U') {
                primerConsonanteInternaPrimerApellido = String.valueOf(apePaterno[i]);
                break;
            }
        }

        //Primera consonante interna (no inicial) del segundo apellido. En caso de no tener segundo apellido, se colocará X.
        if (apellidoMaterno.length() > 0) {
            char[] apeMaterno = apellidoMaterno.toCharArray();
            for (int i = 1; i < apeMaterno.length; i++) {
                if (apeMaterno[i] != 'A' && apeMaterno[i] != 'E' && apeMaterno[i] != 'I' && apeMaterno[i] != 'O' && apeMaterno[i] != 'U') {
                    primerConsonanteInternaSegundoApellido = String.valueOf(apeMaterno[i]);
                    break;
                }
            }
        } else {
            primerConsonanteInternaSegundoApellido = "X";
        }

        //Primera consonante interna (no inicial) del nombre
        //char[] nom = nombre.toCharArray();
        for (int i = 1; i < nom.length; i++) {
            if (nom[i] != 'A' && nom[i] != 'E' && nom[i] != 'I' && nom[i] != 'O' && nom[i] != 'U') {
                primerConsonanteInternaNombre = String.valueOf(nom[i]);
                break;
            }
        }

        //Dígito de 0 para fechas de nacimiento hasta el año 1999 y A para fechas de nacimiento del 2000 en adelante.
        String digito = "";
        if (Integer.parseInt(anio) < 2000) {
            digito = "0";
        } else {
            digito = "A";
        }

        //Retorno de la CURP
        return primerLetraPrimerApellido + primerVocalInternaPrimerApellido + primerLetraSegundoApellido + primerLetraNombre + fechaNacimiento + genero + estado + primerConsonanteInternaPrimerApellido + primerConsonanteInternaSegundoApellido + primerConsonanteInternaNombre + digito + "1";
    }
}
