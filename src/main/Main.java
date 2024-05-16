package main;

import entities.*;


import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int[] xpLevel = {0, 100, 220, 365, 540, 750, 1000, 1300};
        int jungleTempleTimes = 0;

//        JFrame window = new JFrame();

        System.out.println("Bem vindo aventureiro!");
        System.out.println();
        System.out.println("* * * * * * * * *");
        System.out.println();
        int option;
        System.out.print("Escolha o nome do seu personagem: ");
        String name = sc.nextLine();
        Hero hero = new Hero(name);
        System.out.println();

        while (true) {


            if(hero.getLife() <= 0) {
                System.out.println("Encerrando o jogo ...");
                break;
            }
            System.out.println();
            System.out.println(hero.getName() + " Level: " + hero.getLevel() + " Experiencia: " + hero.getExperience() + "/" + xpLevel[hero.getLevel()] + " Life: " + hero.getLife() + "/" + hero.getMaxLife() + " Gold: " + hero.getGold());
            System.out.println("Pocoes de vida: " + hero.getLifePotion());
            System.out.println("Pocoes de mana: " + hero.getManaPotion());
            System.out.println("Arma equipada: " + hero.getEquippedWeapon().getName() + " - Ataque: " + hero.getEquippedWeapon().getAttack());
            System.out.println("Armadura equipada: " + hero.getEquippedArmor().getName() + " - Protecao: " + hero.getEquippedArmor().getArmor());
            System.out.println("Forca: " + hero.getStrength());
            System.out.println("Poder Magico: " + hero.getMaigcPower());
            System.out.println();
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println();
            System.out.println("Escolha uma opcao:");
            System.out.println("2 - Sair da vila em busca de aventura");
            System.out.println("3 - Tomar pocao de vida");
            System.out.println("4 - Ir para a loja");
            System.out.println("5 - Ir para a inventario");
            System.out.println("6 - Sair do jogo");
            System.out.print("Opcao desejada: ");

            option = sc.nextInt();
            if (option == 6) {
                break;
            }
            while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5) {
                System.out.println("Opcao invalida. Tente novamente.");
                System.out.println("2 - Sair da vila em busca de aventura");
                System.out.println("3 - Tomar pocao de vida");
                System.out.println("4 - Ir para a loja");
                System.out.println("5 - Ir para a inventario");
                System.out.println("6 - Sair do jogo");
                System.out.print("Opcao desejada: ");
                option = sc.nextInt();

            }
            if (option == 2) {
                System.out.println();
                System.out.println("-- Onde deseja cacar --?");
                System.out.println("1 - Floresta dos goblins");
                System.out.println("2 - Acampamento dos orcs");
                System.out.println("3 - Caverna do Dragao");
                System.out.println("4 - Dungeon - Templo da Floresta");
                System.out.println("5 - Voltar para a vila");
                System.out.print("Opcao desejada: ");
                int respawnOption = sc.nextInt();
                while (respawnOption != 1 && respawnOption != 2 && respawnOption != 3 && respawnOption != 4){
                    System.out.println("-- Onde deseja cacar --?");
                    System.out.println("1 - Floresta dos goblins");
                    System.out.println("2 - Acampamento dos orcs");
                    System.out.println("3 - Caverna do Dragao");
                    System.out.println("4 - Voltar ao menu principal");
                    System.out.print("Opcao desejada: ");
                    respawnOption = sc.nextInt();
                }
                if (respawnOption == 1) {
                    System.out.println();
                    System.out.println("Bem vindo a Floresta dos Goblins (pra ser bem sincero voce nao eh bem vindo aqui! >:( ");
                    while (true) {

                        if (hero.getLife() > 0) {
                            fight(hero, 1);
                            System.out.println();
                            System.out.println("Deseja continuar cacando ou quer voltar para a vila?");
                            System.out.println("1 - Voltar para a vila");
                            System.out.println("2 - Continuar cacando");
                            System.out.println("3 - Tomar pocao de vida");
                            System.out.print("O que deseja fazer?");
                            int continueHunting = sc.nextInt();
                            if (continueHunting == 1) {
                                break;
                            } else if (continueHunting == 3) {
                                System.out.println(hero.drinkLifePotion());
                            } else if (continueHunting != 2) {
                                while (continueHunting != 1 && continueHunting != 2 && continueHunting != 3) {
                                    System.out.println("Opcao invalida");
                                    System.out.println("Deseja continuar cacando ou quer voltar para a vila?");
                                    System.out.println("1 - Voltar para a vila");
                                    System.out.println("2 - Continuar cacando");
                                    System.out.println("3 - Tomar pocao de vida");
                                    System.out.print("O que deseja fazer?");
                                    continueHunting = sc.nextInt();
                                }
                            }
                        } else {
                            break;
                        }

                    }
                } else if (respawnOption == 2) {
                    System.out.println();
                    System.out.println("Bem vindo ao Acampamento dos Orcs (pra ser bem sincero voce nao eh bem vindo aqui! >:( ");
                    fight(hero, 2);

                } else if (respawnOption == 3) {
                    System.out.println();
                    System.out.println("Que cheiro eh esse? Alguem soltou um pum? Nao, eh cheiro de enxofre por causa do fogo do dragao muahahahaha");
                    fight(hero, 3);

                } else {
                    System.out.println();
                    System.out.println("Tem certeza que dezeja entrar na dungeon? Uma vez dentro soh eh possivel sair apos limpar todas as salas ou morto!");
                    System.out.println("1 - Entrar na Dungeon");
                    System.out.println("2 - voltar");
                    int enterDungeon = sc.nextInt();
                    if (enterDungeon == 1) {

                        JungleTemple jungleTemple = new JungleTemple();
                        jungleTemple.exploreDungeon(hero, jungleTempleTimes);
                        jungleTempleTimes++;
                    }


                }


            } else if (option == 3) {
                String potionMessage = hero.drinkLifePotion();
                System.out.println(potionMessage);
            } else if (option == 4) {
                while (true) {
                    System.out.println();
                    System.out.println("--- Bem vindo a loja de bugigangas ---  Gold: " + hero.getGold());
                    System.out.println("Oque deseja comprar?");
                    System.out.println("1 = Pocao de vida (50 hp) - 10 gold");
                    System.out.println("2 = Pocao de mana (50 mp) - 10 gold");
                    System.out.println("3 = Steel aword (atk 5) - 50 gold");
                    System.out.println("4 = Chain Armor (prot 4) - 40 gold");
                    System.out.println("5 = Sair da loja");
                    System.out.print("Acao desejada: ");
                    int optionStore = sc.nextInt();
                    if (optionStore == 4) {
                        if(hero.getGold() >= 40) {
                            hero.getInventory().add(new ChainArmor());
                            hero.setGold(hero.getGold() - 40);
                            System.out.println("Voce comprou uma Chain Armor por 40 gold.");
                        } else {
                            System.out.println("Voce nao tem gold suficiente.");
                        }
                    } else if (optionStore == 3) {
                        if(hero.getGold() >= 50) {
                            hero.getInventory().add(new SteelSword());
                            hero.setGold(hero.getGold() - 50);
                            System.out.println("Voce comprou uma Steel Sword por 50 gold.");
                        } else {
                            System.out.println("Voce nao tem gold suficiente.");
                        }
                    } else if (optionStore == 2) {
                        System.out.println("Quantas pocoes de mana deseja comprar?: ");
                        int quant = sc.nextInt();
                        String potionBuyingMessage = hero.buyManaPotion(quant);
                        System.out.println(potionBuyingMessage);
                    } else if (optionStore == 1) {
                        System.out.print("Quantas pocoes de cura deseja comprar?: ");
                        int quant = sc.nextInt();
                        String potionBuyingMessage = hero.buyLifePotion(quant);
                        System.out.println(potionBuyingMessage);
                    } else {
                        System.out.println("Voce saiu da loja");
                        break;
                    }
                }

            } else if (option == 5) {
                while (true) {
                    System.out.println();
                    System.out.println("Inventario");
                    System.out.println();
                    for (int i = 0; i < hero.getInventory().size(); i++) {
                        System.out.println((i + 1) + " - " + hero.getInventory().get(i).toString());
                    }
                    System.out.println();
                    System.out.println("Digite 0 para sair ou o numero do item que deseja equipar: ");
                    int inventoryOption = sc.nextInt();
                    if(inventoryOption == 0) {
                        break;
                    } else if (inventoryOption <= hero.getInventory().size()) {
                        inventoryOption--;
                        if (hero.getInventory().get(inventoryOption).getType().equals("weapon")){
                            hero.getInventory().add(hero.getEquippedWeapon());
                            hero.setEquippedWeapon((Weapon) hero.getInventory().get(inventoryOption));
                            hero.getInventory().remove(inventoryOption);
                        } else if (hero.getInventory().get(inventoryOption).getType().equals("armor")){
                            hero.getInventory().add(hero.getEquippedArmor());
                            hero.setEquippedArmor((Armor) hero.getInventory().get(inventoryOption));
                            hero.getInventory().remove(inventoryOption);
                        }

                    }
                }

            } else {
                System.out.println("Voce escolheu sair do jogo");
                break;
            }

        }


    }

    public static void fight(Hero character, int respawn) {
        int[] xpLevel = {0, 100, 220, 365, 540, 750, 1000, 1300};
        Scanner sc = new Scanner(System.in);
        Monster monster;

        if (respawn == 1) {
            monster = new Goblin();
        } else if (respawn == 2){
            monster = new Orc();
        } else if (respawn == 3){
            monster = new Dragon();
        } else {
            monster = new Goblin();
        }

        while (character.getLife() > 0 && monster.getLife() > 0) {
            System.out.println();
            System.out.println("--- MENU DE BATALHA ---");
            System.out.println();
            System.out.println(" Level: " + character.getLevel() + " Experiencia: " + character.getExperience() + "/" + xpLevel[character.getLevel()] + " Life: " + character.getLife() + "/" + character.getMaxLife() + " Gold: " + character.getGold() + " ----- " + monster.getName() + " life: " + monster.getLife());
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
            if (acao == 2 && character.getMana() < 10) {
                while (acao == 2 && character.getMana() < 10) {
                    System.out.println("Mana insuficiente. Tente outra opcao.");
                    System.out.println("1 - Golpe com a espada (0 de mana).");
                    System.out.println("2 - Golpe Magico (10 de mana).");
                    System.out.print("Acao desejada: ");
                    acao = sc.nextInt();
                }

            }
            if (acao == 1) {
                int dano = character.attack();
                monster.takeDamage(dano);
                System.out.println("Voce deu um dano de " + dano + " no monstro");
            } else if (acao == 2) {
                int dano = character.magicAttack();
                monster.takeDamage(dano);
                System.out.println("Voce deu um dano de " + dano + " no monstro");
            } else if (acao == 3) {
                String potionMessage = character.drinkLifePotion();
                System.out.println(potionMessage);
            }
            if (monster.getLife() <= 0) {
                System.out.println();
                System.out.println("----- VITORIA! -----");
                int goldDrop = monster.dropGold();
                character.lootGold(goldDrop);
                character.gainXp(monster.getExperience());
                System.out.println("Voce conseguiu " + goldDrop + " modeas de ouro e " + monster.getExperience() + " de experiencia :D");
                break;
            }

            int charDano = monster.attack() - character.getEquippedArmor().getArmor();
            character.takeDamage(charDano);
            System.out.println("Voce sofreu um dano de " + charDano + " do monstro");
            if (character.getLife() <= 0) {
                System.out.println("Oh nao! Voce morreu!");
                break;
            }

        }
    }
}