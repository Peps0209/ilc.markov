/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfranc.ilc;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author cg467842
 */
public class GoncalvesCindyTest {
    
    String[] couplePara = new String[] {"parapluie", "parachute"};
    MarkovData bonjour = new MarkovData("bonjour", 1);
    List<MarkovData> liste0 = null;
    
    public GoncalvesCindyTest() {
    }
    
    
    @Test
    public boolean test_contains_bonjour_true(String c){
        MarkovWord.data.add(bonjour);
        boolean contient = MarkovWord.data.contains("bonjour");
        return contient;
    }
    
    @Test
    public int test_commom_markovDataList_1(){
        List<MarkovData> liste1 = null;
        liste1.add(bonjour);
        List<MarkovData> liste2 = null;
        liste2.add(bonjour);
        
        int res = 0;
        
        if (liste1.contains(bonjour)==liste2.contains(bonjour)){
            res = 1;
        }
        
        return res;
    }
    
    @Test
    public int test_union_liste1_liste2_1(){
        List<MarkovData> liste1 = null;
        liste1.add(bonjour);
        List<MarkovData> liste2 = null;
        liste2.add(bonjour);
        int res = 0;
        
        if(liste1.get(0).theWord.equalsIgnoreCase(liste2.get(0).theWord)){
            //res = union(liste1, liste2);
        }
        return res;
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
