import util.*;

import javax.sound.midi.SysexMessage;

/**
 * Classe de test pour vérifier le bon fonctionnement de la pile.
 *
 * @author Forestier Quentin, Herzig Melvyn
 * @version 11.11.2020
 */
public class TestStack
{
   public static void main(String[] args)
   {
      System.out.println("------ Pile vide création et affichage string");
      Stack s = new Stack();
      System.out.println(s);

      System.out.println("\n------ Pile vide size et isEmpty");
      System.out.println("Pile vide : " + s.isEmpty());
      System.out.println("Taille    : " + s.size());

      System.out.println("\n------ Pile vide top");
      try
      {
         System.out.println(s.top());
      } catch (RuntimeException e)
      {
         System.out.println("Exception reçue " + e.getMessage());
      }

      System.out.println("\n------ Pile vide pop");
      try
      {
         s.pop();
      } catch (RuntimeException e)
      {
         System.out.println("Exception reçue " + e.getMessage());
      }

      System.out.println("\n------ Pile vide Examinator:");
      Examinator ex = s.examinator();
      System.out.println("Création de l'examinator avec succès");
      try
      {
         System.out.println(ex.next());
      } catch (NullPointerException e)
      {
         System.out.println("NullPointerException reçue lors de next()");
      }

      System.out.println("\n------ Pile vide toArray:");
      printArray(s.toArray());

      System.out.println("\n------ Pile vide push 'a' \"abc\" 4 :");
      s.push('a');
      s.push("abc");
      s.push(4);
      System.out.println(s);

      System.out.println("\n------ Pile remplie modification des element de toArray:");
      System.out.println("Remplacement de 4 par 8 dans l'array retourné.");
      Object[] objects = s.toArray();
      objects[0] = 8;
      System.out.println("Array modifié");
      printArray(objects);
      System.out.println("Etat de la pile");
      System.out.println(s);

      System.out.println("\n------ Pile remplie size et isEmpty");
      System.out.println("Pile vide : " + s.isEmpty());
      System.out.println("Taille    : " + s.size());

      System.out.println("\n------ Pile remplie top");
      try
      {
         System.out.println("Top: " + s.top());
      } catch (RuntimeException e)
      {
         System.out.println("Exception reçue " + e.getMessage());
      }

      System.out.println("\n------ Pile remplie pop");
      try
      {
         s.pop();
         System.out.println(s);
         System.out.println("Pile vide : " + s.isEmpty());
         System.out.println("Taille    : " + s.size());
      } catch (RuntimeException e)
      {
         System.out.println("Exception reçue " + e.getMessage());
      }

      System.out.println("\n------ Pile remplie Examinator:");
      Examinator ex2 = s.examinator();
      System.out.println("Création de l'examinator2 avec succès");
      try
      {
         while (ex2.hasNext())
         {
            System.out.print("hasNext: " + ex2.hasNext() + " | ");
            System.out.println("next : " + ex2.next());
         }
         System.out.print("hasNext: " + ex2.hasNext());
      } catch (NullPointerException e)
      {
         System.out.println("NullPointerException reçue lors de next()");
      }
   }

   /**
    * Affiche le contenu d'un tableau d'object { elem1 elem2 ... }, si vide { }.
    *
    * @param objects Tableau d'objets à afficher.
    */
   static void printArray(Object[] objects)
   {

      System.out.print("{ ");
      for (Object o : objects)
      {
         System.out.print(o + " ");
      }
      System.out.println("}");
   }
}
