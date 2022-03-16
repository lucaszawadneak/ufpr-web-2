/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author lucas
 */
public class DAOException extends Exception {
    public DAOException(){
        
    }
    
    public DAOException(String str){
        super(str);
    }
    
    public DAOException(String str, Throwable tw){
        super(str,tw);
    }
}
