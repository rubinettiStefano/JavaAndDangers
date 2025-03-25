package views;

import model.entities.GameCharacter;

public class CharacterViewAsciiArt implements iCharacterView
{
	@Override
	public String render(GameCharacter gc) {
		StringBuilder sb = new StringBuilder();
		sb.append("       "+gc.getName()+"\n");
		// 1. TESTA (dipende dai capelli)
		switch (gc.getHair()) {
			case NONE:
				sb.append("     _______  \n");
				sb.append("    /       \\ \n");
				sb.append("    |  0 0  | \n");
				sb.append("    \\   ~   / \n");
				sb.append("     \\_____/  \n");
				break;
			case SHORT:
				sb.append("     _______  \n");
				sb.append("    /^^^^^^^\\ \n");
				sb.append("    |^ 0 0 ^| \n");
				sb.append("    \\   ~   / \n");
				sb.append("     \\_____/  \n");
				break;
			case LONG:
				sb.append("     ~~~~~~~~ \n");
				sb.append("    /~~~~~~~~\\\n");
				sb.append("    |~ 0 0  ~|\n");
				sb.append("    \\   ~   / \n");
				sb.append("     \\_____/  \n");
				break;
		}

		sb.append("      |   |\n");
		sb.append("      /   \\ \n");
		sb.append("     |     |\n");

		// 2. ARMI E SCUDO (braccia)
		//    - Scudo a sinistra (se presente)
		//    - Arma a destra
		//    - Il "corpo" è il tratto centrale "|"
		String shield = gc.hasShield() ? "[##]" : "----";
		String weapon;
		switch (gc.getWeapon()) {
			case DAGGER:
				weapon = "      o=={||>  ";
				break;
			case SWORD:
				weapon = "      ===|===> ";
				break;
			case AXE:
				weapon = "      )=====$";
				break;
			default:
				weapon = "           ";
		}
		sb.append(shield).append("  ").append(weapon).append("\n");

		// 3. CORPO (altezza variabile)
		//    Aggiungiamo righe extra se è MEDIUM o TALL
		int extraLines = 0;
		switch (gc.getHeight()) {
			case SHORT:
				extraLines = 0;
				break;
			case MEDIUM:
				extraLines = 1;
				break;
			case TALL:
				extraLines = 4;
				break;
		}
		// Ogni linea del corpo è rappresentata da due barre verticali
		for (int i = 0; i < extraLines + 1; i++) {
			sb.append("    |       |\n");
		}

		// 4. GAMBE
		sb.append("    |       |\n");   // Collegamento
		sb.append("    /       \\\n");
		sb.append("   /         \\\n");

		return sb.toString();
	}

}
