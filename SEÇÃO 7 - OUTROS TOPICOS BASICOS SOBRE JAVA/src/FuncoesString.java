
public class FuncoesString {
	public static void main(String[] args) {
		String original = "Márcio gabriel G mengali";
		String s01 = original.toLowerCase();
		String s02 = original.toUpperCase();
		String s03 = original.trim();
		String s04 = original.substring(2);
		String s05 = original.substring(2,8);
		String s06 = original.replace("a","X");
		String s07 = original.replace("Már","MAR");
		int i = original.indexOf("Már");
		int j = original.lastIndexOf("men");
		String[] vetor = original.split(" ");
		System.out.println("--- String Original: " + original + "----");
		System.out.println(s01);
		System.out.println(s02);
		System.out.println(s03 );
		System.out.println(s04);
		System.out.println(s05);
		System.out.println(s06);
		System.out.println(s07);
		System.out.println(i);
		System.out.println(j);
		System.out.println(vetor[0]);
		System.out.println(vetor[1]);
		System.out.println(vetor[2]);
		System.out.println(vetor[3]);
		
	}
}
