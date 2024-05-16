package entities;

import java.util.Scanner;

public class JungleTemple {
    Scanner sc = new Scanner(System.in);
    int[] xpLevel = {0, 100, 220, 365, 540, 750, 1000, 1300};
    Monster monster;

    public void exploreDungeon(Hero hero, int times) {
        System.out.println("Voce acaba de entrar nas ruinas de um antigo templo encontrado no meio da floresta dos goblins...");
        for (int i = 0; i < 10; i++) {
            double exploringLuck = Math.random() * 10;
            if (exploringLuck < 8) {
                System.out.println();
                System.out.println("Voce encontra uma sala antiga com paredes de pedra e suja de musgo, de repende voce " +
                        "ouve um barulho e um goblin salta em sua frente soltando um grunhido horrivel");
                System.out.println();
                monster = new Goblin();
                while (hero.getLife() > 0 && monster.getLife() > 0) {

                    System.out.println("--- MENU DE BATALHA ---");
                    System.out.println();
                    System.out.println(" Level: " + hero.getLevel() + " Experiencia: " + hero.getExperience() + "/" + xpLevel[hero.getLevel()] + " Life: " + hero.getLife() + "/" + hero.getMaxLife() + " Gold: " + hero.getGold() + " ----- " + monster.getName() + " life: " + monster.getLife());
                    System.out.println();
                    System.out.println("1 - Golpe com a espada (0 de mana).");
                    System.out.println("2 - Golpe Magico (10 de mana).");
                    System.out.println("3 - Tomar pocao de vida.");

                    System.out.print("Acao desejada: ");
                    int acao = sc.nextInt();
                    while (acao != 1 && acao != 2 && acao != 3) {
                        System.out.println("Opcao invalida. Tente novamente.");
                        System.out.println("1 - Golpe com a espada (0 de mana).");
                        System.out.println("2 - Golpe Magico (10 de mana).");
                        System.out.println("3 - Tomar pocao de vida.");
                        System.out.print("Acao desejada: ");
                        acao = sc.nextInt();
                    }
                    if (acao == 2 && hero.getMana() < 10) {
                        while (acao == 2 && hero.getMana() < 10) {
                            System.out.println("Mana insuficiente. Tente outra opcao.");
                            System.out.println("1 - Golpe com a espada (0 de mana).");
                            System.out.println("2 - Golpe Magico (10 de mana).");
                            System.out.print("Acao desejada: ");
                            acao = sc.nextInt();
                        }

                    }
                    if (acao == 1) {
                        int dano = hero.attack();
                        monster.takeDamage(dano);
                        System.out.println("Voce deu um dano de " + dano + " no monstro");
                    } else if (acao == 2) {
                        int dano = hero.magicAttack();
                        monster.takeDamage(dano);
                        System.out.println("Voce deu um dano de " + dano + " no monstro");
                    } else if (acao == 3) {
                        String potionMessage = hero.drinkLifePotion();
                        System.out.println(potionMessage);
                    }
                    if (monster.getLife() <= 0) {
                        System.out.println();
                        System.out.println("----- VITORIA! -----");
                        int goldDrop = monster.dropGold();
                        hero.lootGold(goldDrop);
                        hero.gainXp(monster.getExperience());
                        System.out.println("Voce conseguiu " + goldDrop + " modeas de ouro e " + monster.getExperience() + " de experiencia :D");
                        break;
                    }

                    int charDano = monster.attack() - hero.getEquippedArmor().getArmor();
                    hero.takeDamage(charDano);
                    System.out.println("Voce sofreu um dano de " + charDano + " do monstro");
                    if (hero.getLife() <= 0) {
                        System.out.println("Oh nao! Voce morreu!");
                        break;
                    }

                }
            } else {
                if (hero.getLife() > 0) {
                    System.out.println();
                    System.out.println("Voce tem muita sorte! Encontrou um bau!");
                    int gold = (int) Math.ceil(20 + Math.random() * 20);
                    int lifePotion = (int) Math.ceil(Math.random() * 3);
                    int manaPotion = (int) Math.ceil(Math.random() * 3);
                    int xp = (int) Math.ceil(30 + Math.random() * 30);
                    System.out.println("Voce ganhou " + xp + " pontos de experiencia, " + gold + " moedas de ouro, " + lifePotion + " pocoes de vida e " + manaPotion + " pocoes de mana!");

                }

            }
            if (hero.getLife() > 0) {
                System.out.println("Voce ve uma abertura para outra sala, deseja tomar uma pocao antes de entrar?");
                System.out.println("1 - Tomar um pocao de vida");
//                System.out.println("2 - Tomar um pocao de mana");
                System.out.println("2 - Seguir para a proxima sala");
                int goOn = sc.nextInt();

                while (goOn != 2 && goOn != 1) {

                    System.out.println("Opcao invalida. Tente novamente.");
                    System.out.println("1 - Tomar um pocao de vida");
                    System.out.println("2 - Seguir para a proxima sala");
                    goOn = sc.nextInt();

                }
                if (goOn == 1) {
                    System.out.println(hero.drinkLifePotion());
                }
            }

        }
        monster = new GoblinChief();
        if (hero.getLife() > 0) {
            System.out.println("Voce chegou na ultima sala, voce consegue ver um grande tesouro no canto, mas ouve um barulho e percebe que a sala nao esta vazia ..");
            System.out.println("Subitamente salta na sua frente um goblin com o dobro do tamanho normal, ele usa uma coroa antiga e um machado em sua mao...");
            System.out.println("Sem fazer cerimonias ele parte para o combate!");
            System.out.println();
        }
        while (hero.getLife() > 0 && monster.getLife() > 0) {

            System.out.println("--- MENU DE BATALHA ---");
            System.out.println();
            System.out.println(" Level: " + hero.getLevel() + " Experiencia: " + hero.getExperience() + "/" + xpLevel[hero.getLevel()] + " Life: " + hero.getLife() + "/" + hero.getMaxLife() + " Gold: " + hero.getGold() + " ----- " + monster.getName() + " life: " + monster.getLife());
            System.out.println();
            System.out.println("1 - Golpe com a espada (0 de mana).");
            System.out.println("2 - Golpe Magico (10 de mana).");
            System.out.println("3 - Tomar pocao de vida.");

            System.out.print("Acao desejada: ");
            int acao = sc.nextInt();
            while (acao != 1 && acao != 2 && acao != 3) {
                System.out.println("Opcao invalida. Tente novamente.");
                System.out.println("1 - Golpe com a espada (0 de mana).");
                System.out.println("2 - Golpe Magico (10 de mana).");
                System.out.print("Acao desejada: ");
                acao = sc.nextInt();
            }
            if (acao == 2 && hero.getMana() < 10) {
                while (acao == 2 && hero.getMana() < 10) {
                    System.out.println("Mana insuficiente. Tente outra opcao.");
                    System.out.println("1 - Golpe com a espada (0 de mana).");
                    System.out.println("2 - Golpe Magico (10 de mana).");
                    System.out.print("Acao desejada: ");
                    acao = sc.nextInt();
                }

            }
            if (acao == 1) {
                int dano = hero.attack();
                monster.takeDamage(dano);
                System.out.println("Voce deu um dano de " + dano + " no monstro");
            } else if (acao == 2) {
                int dano = hero.magicAttack();
                monster.takeDamage(dano);
                System.out.println("Voce deu um dano de " + dano + " no monstro");
            } else if (acao == 3) {
                String potionMessage = hero.drinkLifePotion();
                System.out.println(potionMessage);
            }
            if (monster.getLife() <= 0) {
                System.out.println();
                System.out.println("----- VITORIA! -----");
                int goldDrop = monster.dropGold();
                hero.lootGold(goldDrop);
                hero.gainXp(monster.getExperience());
                System.out.println("Voce conseguiu " + goldDrop + " modeas de ouro e " + monster.getExperience() + " de experiencia :D");
                break;
            }

            int charDano = monster.attack() - hero.getEquippedArmor().getArmor();
            hero.takeDamage(charDano);
            System.out.println("Voce sofreu um dano de " + charDano + " do monstro");
            if (hero.getLife() <= 0) {
                System.out.println("Oh nao! Voce morreu!");
                break;
            }

        }
        if (hero.getLife() > 0) {
            System.out.println();
            System.out.println("Voce finalmente pode tomar posse dos seus espolios de batalha!");
            int gold = (int) Math.ceil(20 + Math.random() * 20);
            int lifePotion = (int) Math.ceil(Math.random() * 3);
            int manaPotion = (int) Math.ceil(Math.random() * 3);
            int xp = (int) Math.ceil(30 + Math.random() * 30);
            System.out.println("Voce ganhou " + xp + " pontos de experiencia, " + gold + " moedas de ouro, " + lifePotion + " pocoes de vida e " + manaPotion + " pocoes de mana!");
            if (times < 1) {
                Weapon greatAxe = new GreatAxe();
                hero.getInventory().add(greatAxe);
                System.out.println("Voce encontrou o lendario Great axe!");
            }
        }
    }
}
