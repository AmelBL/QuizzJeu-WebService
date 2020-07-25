/**
 * Question.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bean;

public class Question  implements java.io.Serializable {
    private int bonnereponse;

    private java.lang.String enonce;

    private int idquestion;

    private bean.Partie partie;

    private int repjoueur;

    private java.lang.String reponse1;

    private java.lang.String reponse2;

    private java.lang.String reponse3;

    private java.lang.String reponse4;

    private int score;

    public Question() {
    }

    public Question(
           int bonnereponse,
           java.lang.String enonce,
           int idquestion,
           bean.Partie partie,
           int repjoueur,
           java.lang.String reponse1,
           java.lang.String reponse2,
           java.lang.String reponse3,
           java.lang.String reponse4,
           int score) {
           this.bonnereponse = bonnereponse;
           this.enonce = enonce;
           this.idquestion = idquestion;
           this.partie = partie;
           this.repjoueur = repjoueur;
           this.reponse1 = reponse1;
           this.reponse2 = reponse2;
           this.reponse3 = reponse3;
           this.reponse4 = reponse4;
           this.score = score;
    }


    /**
     * Gets the bonnereponse value for this Question.
     * 
     * @return bonnereponse
     */
    public int getBonnereponse() {
        return bonnereponse;
    }


    /**
     * Sets the bonnereponse value for this Question.
     * 
     * @param bonnereponse
     */
    public void setBonnereponse(int bonnereponse) {
        this.bonnereponse = bonnereponse;
    }


    /**
     * Gets the enonce value for this Question.
     * 
     * @return enonce
     */
    public java.lang.String getEnonce() {
        return enonce;
    }


    /**
     * Sets the enonce value for this Question.
     * 
     * @param enonce
     */
    public void setEnonce(java.lang.String enonce) {
        this.enonce = enonce;
    }


    /**
     * Gets the idquestion value for this Question.
     * 
     * @return idquestion
     */
    public int getIdquestion() {
        return idquestion;
    }


    /**
     * Sets the idquestion value for this Question.
     * 
     * @param idquestion
     */
    public void setIdquestion(int idquestion) {
        this.idquestion = idquestion;
    }


    /**
     * Gets the partie value for this Question.
     * 
     * @return partie
     */
    public bean.Partie getPartie() {
        return partie;
    }


    /**
     * Sets the partie value for this Question.
     * 
     * @param partie
     */
    public void setPartie(bean.Partie partie) {
        this.partie = partie;
    }


    /**
     * Gets the repjoueur value for this Question.
     * 
     * @return repjoueur
     */
    public int getRepjoueur() {
        return repjoueur;
    }


    /**
     * Sets the repjoueur value for this Question.
     * 
     * @param repjoueur
     */
    public void setRepjoueur(int repjoueur) {
        this.repjoueur = repjoueur;
    }


    /**
     * Gets the reponse1 value for this Question.
     * 
     * @return reponse1
     */
    public java.lang.String getReponse1() {
        return reponse1;
    }


    /**
     * Sets the reponse1 value for this Question.
     * 
     * @param reponse1
     */
    public void setReponse1(java.lang.String reponse1) {
        this.reponse1 = reponse1;
    }


    /**
     * Gets the reponse2 value for this Question.
     * 
     * @return reponse2
     */
    public java.lang.String getReponse2() {
        return reponse2;
    }


    /**
     * Sets the reponse2 value for this Question.
     * 
     * @param reponse2
     */
    public void setReponse2(java.lang.String reponse2) {
        this.reponse2 = reponse2;
    }


    /**
     * Gets the reponse3 value for this Question.
     * 
     * @return reponse3
     */
    public java.lang.String getReponse3() {
        return reponse3;
    }


    /**
     * Sets the reponse3 value for this Question.
     * 
     * @param reponse3
     */
    public void setReponse3(java.lang.String reponse3) {
        this.reponse3 = reponse3;
    }


    /**
     * Gets the reponse4 value for this Question.
     * 
     * @return reponse4
     */
    public java.lang.String getReponse4() {
        return reponse4;
    }


    /**
     * Sets the reponse4 value for this Question.
     * 
     * @param reponse4
     */
    public void setReponse4(java.lang.String reponse4) {
        this.reponse4 = reponse4;
    }


    /**
     * Gets the score value for this Question.
     * 
     * @return score
     */
    public int getScore() {
        return score;
    }


    /**
     * Sets the score value for this Question.
     * 
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Question)) return false;
        Question other = (Question) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.bonnereponse == other.getBonnereponse() &&
            ((this.enonce==null && other.getEnonce()==null) || 
             (this.enonce!=null &&
              this.enonce.equals(other.getEnonce()))) &&
            this.idquestion == other.getIdquestion() &&
            ((this.partie==null && other.getPartie()==null) || 
             (this.partie!=null &&
              this.partie.equals(other.getPartie()))) &&
            this.repjoueur == other.getRepjoueur() &&
            ((this.reponse1==null && other.getReponse1()==null) || 
             (this.reponse1!=null &&
              this.reponse1.equals(other.getReponse1()))) &&
            ((this.reponse2==null && other.getReponse2()==null) || 
             (this.reponse2!=null &&
              this.reponse2.equals(other.getReponse2()))) &&
            ((this.reponse3==null && other.getReponse3()==null) || 
             (this.reponse3!=null &&
              this.reponse3.equals(other.getReponse3()))) &&
            ((this.reponse4==null && other.getReponse4()==null) || 
             (this.reponse4!=null &&
              this.reponse4.equals(other.getReponse4()))) &&
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
        _hashCode += getBonnereponse();
        if (getEnonce() != null) {
            _hashCode += getEnonce().hashCode();
        }
        _hashCode += getIdquestion();
        if (getPartie() != null) {
            _hashCode += getPartie().hashCode();
        }
        _hashCode += getRepjoueur();
        if (getReponse1() != null) {
            _hashCode += getReponse1().hashCode();
        }
        if (getReponse2() != null) {
            _hashCode += getReponse2().hashCode();
        }
        if (getReponse3() != null) {
            _hashCode += getReponse3().hashCode();
        }
        if (getReponse4() != null) {
            _hashCode += getReponse4().hashCode();
        }
        _hashCode += getScore();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Question.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean/", "question"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bonnereponse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bonnereponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enonce");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enonce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idquestion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idquestion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean/", "partie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repjoueur");
        elemField.setXmlName(new javax.xml.namespace.QName("", "repjoueur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reponse1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reponse1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reponse2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reponse2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reponse3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reponse3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reponse4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reponse4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
