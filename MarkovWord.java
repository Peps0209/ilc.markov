package cfranc.ilc;

import java.util.ArrayList;
import java.util.List;

public class MarkovWord {
	 
	public static ArrayList<MarkovData> data = new ArrayList<MarkovData>();

        public MarkovWord(){
            
        }
	public MarkovWord(String dataWord, int n) {
            data = (ArrayList<MarkovData>)processString(dataWord, n);
	}
        //permet de trouver le pourcentage de ressemblance entre deux mots
	public double getSimilarity(String wordOne, String wordTwo, int n) {
		List<MarkovData> res1 = processString(wordOne, n);
		// displayResult(res1);
		List<MarkovData> res2 = processString(wordTwo, n);
		// displayResult(res2);
		int c = common(res1, res2);
		int u = union(res1, res2);
		double sim = (double) c / (double) u;

		return sim;
	}
        
        //Compare la similarité entre deux listes de markovdata
	int common(List<MarkovData> One, List<MarkovData> Two) {
		int res = 0;

		for (int i = 0; i < One.size(); i++) {
			for (int j = 0; j < Two.size(); j++) {
				if (One.get(i).theWord.equalsIgnoreCase(Two.get(j).theWord))
					res++;
			}
		}

		return res;
	}

	int union(List<MarkovData> One, List<MarkovData> Two) {
		List<MarkovData> t = One;

		for (int i = 0; i < Two.size(); i++) {
			int pos = -1;
			boolean found = false;
			for (int j = 0; j < t.size() && !found; j++) {
				if (Two.get(i).theWord.equalsIgnoreCase(t.get(j).theWord)) {
					found = true;
				}
				pos = j;
			}

			if (!found) {
				MarkovData r = Two.get(i);
				t.add(r);
			}
		}

		return t.size();
	}

        //creer des couples d'elements qui forment des paires
        //en fonction des entrées
        //n = nbre d'element qu'il y a dans le couple d'analyse
        //n=nombre de caractere pour trouver les correspondances
	List<MarkovData> processString(String c, int n) {
		List<MarkovData> t = new ArrayList<MarkovData>();

		String spacer = "";
		for (int i = 0; i < n - 1; i++) {
			spacer = spacer + "%";
		}
		c = spacer + c + spacer;

		for (int i = 0; i < c.length(); i++) {
			if (i <= (c.length() - n)) {
				if (contains(c.substring(i, n + i)) > 0) {
					t.get(i).setTheCount(data.get(i).getTheCount() + 1);
				} else {
					t.add(new MarkovData(c.substring(i, n + i), 1));
				}
			}
		}
		return t;
	}

	int contains(String c) {
		for (int i = 0; i < data.size(); i++) {                 //parcours la liste data
			if (data.get(i).theWord.equalsIgnoreCase(c))    //compare si le mot c est déjà dans la liste
				return i;                               //retourne le rang où se trouve le mot c dans la liste data
		}
		return 0;
	}
	
        //Affiche une phrase qui donne le nombre de fois que chaque mot apparaît
	private void displayResult(List<MarkovData> d) {
		for (int i = 0; i < d.size(); i++) { 
			System.out.println(d.get(i).theWord + " occurred " + d.get(i).theCount + " times");
		}
	}
}
