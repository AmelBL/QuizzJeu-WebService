/**
 * Quizz1Bean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bean;

public interface Quizz1Bean extends java.rmi.Remote {
    public void ajouterJoueur(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public bean.Joueur trouverJoueur(java.lang.String arg0) throws java.rmi.RemoteException;
    public int ajouterPartie(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
    public bean.Partie trouvePartie(int arg0) throws java.rmi.RemoteException;
    public int chargerQst(java.lang.String[] arg0) throws java.rmi.RemoteException;
    public bean.Question trouvQuestion(int arg0) throws java.rmi.RemoteException;
    public void majQuestion(bean.Question[] arg0, int[] arg1, bean.Partie arg2) throws java.rmi.RemoteException;
}
