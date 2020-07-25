package bean;

public class Quizz1BeanProxy implements bean.Quizz1Bean {
  private String _endpoint = null;
  private bean.Quizz1Bean quizz1Bean = null;
  
  public Quizz1BeanProxy() {
    _initQuizz1BeanProxy();
  }
  
  public Quizz1BeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initQuizz1BeanProxy();
  }
  
  private void _initQuizz1BeanProxy() {
    try {
      quizz1Bean = (new bean.Quizz1BeanServiceLocator()).getQuizz1beanPort();
      if (quizz1Bean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)quizz1Bean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)quizz1Bean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (quizz1Bean != null)
      ((javax.xml.rpc.Stub)quizz1Bean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public bean.Quizz1Bean getQuizz1Bean() {
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    return quizz1Bean;
  }
  
  public void ajouterJoueur(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    quizz1Bean.ajouterJoueur(arg0, arg1, arg2);
  }
  
  public bean.Joueur trouverJoueur(java.lang.String arg0) throws java.rmi.RemoteException{
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    return quizz1Bean.trouverJoueur(arg0);
  }
  
  public int ajouterPartie(java.lang.String arg0, int arg1) throws java.rmi.RemoteException{
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    return quizz1Bean.ajouterPartie(arg0, arg1);
  }
  
  public bean.Partie trouvePartie(int arg0) throws java.rmi.RemoteException{
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    return quizz1Bean.trouvePartie(arg0);
  }
  
  public int chargerQst(java.lang.String[] arg0) throws java.rmi.RemoteException{
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    return quizz1Bean.chargerQst(arg0);
  }
  
  public bean.Question trouvQuestion(int arg0) throws java.rmi.RemoteException{
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    return quizz1Bean.trouvQuestion(arg0);
  }
  
  public void majQuestion(bean.Question[] arg0, int[] arg1, bean.Partie arg2) throws java.rmi.RemoteException{
    if (quizz1Bean == null)
      _initQuizz1BeanProxy();
    quizz1Bean.majQuestion(arg0, arg1, arg2);
  }
  
  
}