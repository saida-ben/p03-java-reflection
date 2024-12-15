package org.mql.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ClassParser {
    private String nomClasse;

    // Constructeur
    public ClassParser(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    // Fonction pour parser la classe et générer le squelette
    public String parseClass() throws ClassNotFoundException {
        // Récupération de la classe par son nom
        Class<?> classe = Class.forName(nomClasse);
        StringBuilder skeleton = new StringBuilder();

        // Modificateurs et nom de la classe
        skeleton.append(Modifier.toString(classe.getModifiers()))
                .append(" class ")
                .append(classe.getSimpleName())
                .append(" ");

        // Classe parente
        Class<?> superclass = classe.getSuperclass();
        if (superclass != null) {
            skeleton.append("extends ").append(superclass.getSimpleName()).append(" ");
        }

        // Interfaces implémentées
        Class<?>[] interfaces = classe.getInterfaces();
        if (interfaces.length > 0) {
            skeleton.append("implements ");
            for (int i = 0; i < interfaces.length; i++) {
                skeleton.append(interfaces[i].getSimpleName());
                if (i < interfaces.length - 1) {
                    skeleton.append(", ");
                }
            }
        }

        skeleton.append("\n{\n");

        // Affichage des champs (propriétés)
        appendFields(classe, skeleton);

        // Affichage des constructeurs
        appendConstructors(classe, skeleton);

        // Affichage des méthodes
        appendMethods(classe, skeleton);

        // Affichage des classes internes
        appendInnerClasses(classe, skeleton);

        skeleton.append("}\n");
        
        int fieldCount = appendFields(classe, skeleton);
        int methodCount = appendMethods(classe, skeleton);

        // Informations supplémentaires : nombre de propriétés, méthodes et chaîne d'héritage
        skeleton.append("\nInformations extraites :\n");
        skeleton.append("- Nombre de propriétés : ").append(fieldCount).append("\n");
        skeleton.append("- Nombre de méthodes : ").append(methodCount).append("\n");
        skeleton.append("- Chaîne d'héritage : ");
        appendInheritanceChain(classe, skeleton);

        return skeleton.toString();
    }

    // Méthode pour afficher les champs
    private int appendFields(Class<?> classe, StringBuilder skeleton) {
        Field[] fields = classe.getDeclaredFields();
        for (Field field : fields) {
            skeleton.append("\t")
                    .append(Modifier.toString(field.getModifiers()))
                    .append(" ")
                    .append(field.getType().getSimpleName())
                    .append(" ")
                    .append(field.getName())
                    .append(";\n");
        }
        return fields.length;

    }

    // Méthode pour afficher les constructeurs
    private void appendConstructors(Class<?> classe, StringBuilder skeleton) {
        Constructor<?>[] constructors = classe.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            skeleton.append("\n\t")
                    .append(Modifier.toString(constructor.getModifiers()))
                    .append(" ")
                    .append(constructor.getName())
                    .append("(");
            Parameter[] parameters = constructor.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter param = parameters[i];
                skeleton.append(param.getType().getSimpleName())
                        .append(" ")
                        .append(param.getName());
                if (i < parameters.length - 1) {
                    skeleton.append(", ");
                }
            }
            skeleton.append(") {}\n");
        }
    }

    // Méthode pour afficher les méthodes
    private int appendMethods(Class<?> classe, StringBuilder skeleton) {
        Method[] methods = classe.getDeclaredMethods();
        for (Method method : methods) {
            skeleton.append("\n\t")
                    .append(Modifier.toString(method.getModifiers()))
                    .append(" ")
                    .append(method.getReturnType().getSimpleName())
                    .append(" ")
                    .append(method.getName())
                    .append("(");
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter param = parameters[i];
                skeleton.append(param.getType().getSimpleName())
                        .append(" ")
                        .append(param.getName());
                if (i < parameters.length - 1) {
                    skeleton.append(", ");
                }
            }
            skeleton.append(") {}\n");

        }            return methods.length;

    }

    // Méthode pour afficher les classes internes
    private void appendInnerClasses(Class<?> classe, StringBuilder skeleton) {
        Class<?>[] innerClasses = classe.getDeclaredClasses();
        for (Class<?> innerClass : innerClasses) {
            skeleton.append("\n\tclass ")
                    .append(innerClass.getSimpleName())
                    .append(" {\n\t}\n");
        }
    }
    
    // Méthode pour afficher la chaîne d'héritage
    private void appendInheritanceChain(Class<?> clazz, StringBuilder output) {
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            output.append(currentClass.getSimpleName());
            currentClass = currentClass.getSuperclass();
            if (currentClass != null) {
                output.append(" -> ");
            }
        }
        output.append("\n");
    }


    // Méthode principale pour tester la classe
    public static void main(String[] args) {
        ClassParser parser = new ClassParser("org.mql.java.reflection.ui.Menu");
        try {
            System.out.println(parser.parseClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
