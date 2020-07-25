/**
 * Partie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bean;

public class Partie  implements java.io.Serializable {
    private int idpartie;

    private bean.Joueur joueur;

    private bean.Question[] questions;

    private int score;

    public Partie() {
    }

    public Partie(
           int idpartie,
           bean.Joueur joueur,
           bean.Question[] questions,
           int score) {
           this.idpartie = idpartie;
           this.joueur = joueur;
           this.questions = questions;
           this.score = score;
    }


    /**
     * Gets the idpartie value for this Partie.
     * 
     * @return idpartie
     */
    public int getIdpartie() {
        return idpartie;
    }


    /**
     * Sets the idpartie value for this Partie.
     * 
     * @param idpartie
     */
    public void setIdpartie(int idpartie) {
        this.idpartie = idpartie;
    }


    /**
     * Gets the joueur value for this Partie.
     * 
     * @return joueur
     */
    public bean.Joueur getJoueur() {
        return joueur;
    }


    /**
     * Sets the joueur value for this Partie.
     * 
     * @param joueur
     */
    public void setJoueur(bean.Joueur joueur) {
        this.joueur = joueur;
    }


    /**
     * Gets the questions value for this Partie.
     * 
     * @return questions
     */
    public bean.Question[] getQuestions() {
        return questions;
    }


    /**
     * Sets the questions value for this Partie.
     * 
     * @param questions
     */
    public void setQuestions(bean.Question[] questions) {
        this.questions = questions;
    }

    public bean.Question getQuestions(int i) {
        return this.questions[i];
    }

    public void setQuestions(int i, bean.Question _value) {
        this.questions[i] = _value;
    }


    /**
     * Gets the score value for this Partie.
     * 
     * @return score
     */
    public int getScore() {
        return score;
    }


    /**
     * Sets the score value for this Partie.
     * 
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Partie)) return false;
        Partie other = (Partie) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idpartie == other.getIdpartie() &&
            ((this.joueur==null && other.getJoueur()==null) || 
             (this.joueur!=null &&
              this.joueur.equals(other.getJoueur()))) &&
            ((this.questions==null && other.getQuestions()==null) || 
             (this.questions!=null &&
              java.util.Arrays.equals(this.questions, other.getQuestions()))) &&
            this.score == other.getScore();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getIdpartie();
        if (getJoueur() != null) {
            _hashCode += getJoueur().hashCode();
        }
        if (getQuestions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQuestions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQuestions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getScore();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Partie.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean/", "partie"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idpartie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idpartie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("joueur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "joueur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean/", "joueur"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("questions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "questions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean/", "question"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("score");
        elemField.setXmlName(new javax.xml.namespace.QName("", "score"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
