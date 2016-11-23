/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setupTestData;


import javax.persistence.Persistence;
/**
 *
 * @author Michael
 */
public class GenerateSchema {
    
    public GenerateSchema(){
    }
    
    public void initSchema(){
        Persistence.generateSchema("mmp", null);
    }
    
}
