/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rodrigopeniche
 */
public interface Queue {
    
    public void enqueue(Object dato);
    public Object dequeue();
    public int size();
    public Object front();
    public boolean isEmpty();
    
}
