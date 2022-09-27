package mx.itson.radiant.negocio;

public class Curp {
    public String generarCurp(String nombre, String apellidoPaterno, String apellidoMaterno, String dia, String mes, String anio, String genero, String estado) {

        String primerLetraPrimerApellido = "";
        String primerVocalInternaPrimerApellido = "";
        String primerLetraSegundoApellido = "";
        String primerLetraNombre = "";
        String primerConsonanteInternaPrimerApellido = "";
        String primerConsonanteInternaSegundoApellido = "";
        String primerConsonanteInternaNombre = "";

        //convertir a mayusculas
        nombre = nombre.toUpperCase();
        apellidoPaterno = apellidoPaterno.toUpperCase();
        apellidoMaterno = apellidoMaterno.toUpperCase();

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
        char[] apeMaterno = apellidoMaterno.toCharArray();
        for (int i = 0; i < apeMaterno.length; i++) {
            if (i == 0) {
                primerLetraSegundoApellido = String.valueOf(apeMaterno[i]);
            }
        }

        //Primera letra del nombre de pila. En nombres compuestos que comiencen con José o María, se tomará en cuenta la primera letra segundo nombre.
        char[] nom = nombre.toCharArray();
        for (int i = 0; i < nom.length; i++) {
            if (i == 0) {
                primerLetraNombre = String.valueOf(nom[i]);
            }
        }

        //Fecha de nacimiento sin espacios en orden de AAMMDD.
        char[] anioChar = anio.toCharArray();
        String anioCorto = "";
        for (int i = 2; i < anioChar.length; i++) {
            anioCorto += anioChar[i];
        }
        String fechaNacimiento = anioCorto + mes + dia;

        //Sexo. Hombre = H, Mujer = M.
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
        if (apellidoMaterno.equals("")) {
            primerConsonanteInternaSegundoApellido = "X";
        } else {
            for (int i = 1; i < apeMaterno.length; i++) {
                if (apeMaterno[i] != 'A' && apeMaterno[i] != 'E' && apeMaterno[i] != 'I' && apeMaterno[i] != 'O' && apeMaterno[i] != 'U') {
                    primerConsonanteInternaSegundoApellido = String.valueOf(apeMaterno[i]);
                    break;
                }
            }
        }

        //Primera consonante interna (no inicial) del nombre
        for (int i = 1; i < nom.length; i++) {
            if (nom[i] != 'A' && nom[i] != 'E' && nom[i] != 'I' && nom[i] != 'O' && nom[i] != 'U') {
                primerConsonanteInternaNombre = String.valueOf(nom[i]);
                break;
            }
        }

        //Dígito de 0 para fechas de nacimiento hasta el año 1999 y A para fechas de nacimiento del 2000 en adelante.
        String digito = "";
        int anioInt = Integer.parseInt(anio);
        if (anioInt < 2000) {
            digito = "0";
        } else {
            digito = "A";
        }

        //Generar CURP
        return primerLetraPrimerApellido + primerVocalInternaPrimerApellido + primerLetraSegundoApellido + primerLetraNombre + fechaNacimiento + genero + estado + primerConsonanteInternaPrimerApellido + primerConsonanteInternaSegundoApellido + primerConsonanteInternaNombre + digito + "1";
    }

}
