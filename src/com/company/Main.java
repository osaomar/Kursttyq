package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Apartment> apartments = new ArrayList<>();
        Apartment ap1 = new Apartment(60, 50, 10,true, false, true, false, true, 10, 7, "Mangilik el 10", 20000000);
        Apartment ap2 = new Apartment(100, 90, 15,true, false, true, true, false, 18, 16, "Mangilik el 16", 30000000);
        apartments.add(ap1);
        apartments.add(ap2);
        int menu;
        do{
            System.out.println("Алға жылжу үшін әрекетті таңдаңыз\n" +
                    "0. Шығу\n" +
                    "1. Пәтерді еңгізу\n" +
                    "2. Пәтерді іздеу\n"+
                    "3. Пәтерлердің список\n ");
            menu = sc.nextInt();
            switch (menu) {
                case 3:
                    System.out.println("Пәтерлердің список:");
                    for (Apartment apartment : apartments) {
                        System.out.println(apartment.toString()+"\n");
                    }break;
                case 1:
                    Apartment ap = new Apartment();
                    System.out.println("Сіз еңгізетің пәтердің ауданы:\n");
                    ap.setTotalArea(sc.nextDouble());
                    System.out.println("Сіз еңгізетің пәтердің тұрғын ауданы:\n");
                    ap.setLivingArea(sc.nextDouble());
                    if (ap.getTotalArea() < ap.getLivingArea()) {
                        System.out.println("Еңгізілген мән қате!");
                        break;
                    }
                    System.out.println("Сіз еңгізетің пәтердің ас бөлменің ауданы:\n");
                    ap.setKitchenArea(sc.nextDouble());
                    if ((ap.getLivingArea() + ap.getKitchenArea()) > ap.getTotalArea()) {
                        System.out.println("Еңгізілген мән қате!");
                        break;
                    }
                    System.out.println("Жуынатын бөлме біріккен болса, 1 жазыңыз, әйтпесе 0 жазыңыз:\n");
                    int bath = sc.nextInt();
                    if (bath == 1) {
                        ap.setBathroomConnected(true);
                    } else if (bath == 0) {
                        ap.setExistBathroom(true);
                    } else {
                        break;
                    }
                    System.out.println("Лоджи болса, 1 жазыңыз, әйтпесе 0 жазыңыз:\n");
                    int lodzi = sc.nextInt();
                    if (lodzi == 1) {
                        ap.setExistLoggia(true);
                    } else if (lodzi == 0) {
                        ap.setExistLoggia(false);
                    } else {
                        break;
                    }
                    System.out.println("Пәтер панельді болса, 1 жазыңыз, әйтпесе 0 жазыңыз:\n");
                    int brick = sc.nextInt();
                    if (brick == 1) {
                        ap.setBrick(true);
                    } else if (brick == 0) {
                        ap.setPanel(true);
                    } else {
                        break;
                    }
                    System.out.println("Сіз еңгізетің үйдін этажі:\n");
                    ap.setTotalLevels(sc.nextInt());
                    System.out.println("Сіз еңгізетің пәтердің этажі:\n");
                    ap.setLevelOfApartment(sc.nextInt());
                    if (ap.getTotalLevels() < ap.getLevelOfApartment()) {
                        System.out.println("Еңгізілген мән қате!");
                        break;
                    }
                    System.out.println("Сіз еңгізетің пәтердің бағесы\n");
                    ap.setCost(sc.nextInt());
                    apartments.add(ap);
                    break;
                case 2:
                    System.out.println("Пәтер іздегіңіз келетін параметірді таңдаңыз:\n" +
                            "1. Минималды баға\n" +
                            "2. Максималды бағасы\n" +
                            "3. Максималды жалпы ауданы бойынша\n" +
                            "4. Ең аз жалпы аудан бойынша\n" +
                            "5. Минималды тұрғын ауданы бойынша\n" +
                            "6. Максималды тұрғын ауданы ауданы бойынша\n" +
                            "7. Лоджи пәтерлер\n" +
                            "8. Лоджи емес пәтерлер\n" +
                            "9. Жуынатын бөлмесі біріккен пәтерлер\n" +
                            "10. Жуынатын бөлмесі бөлек пәтерлер\n" +
                            "11. Панель үйлер\n" +
                            "12. Кірпіш үйлер\n" +
                            "13. Үйдін максималды қабаты бойынша\n" +
                            "14. Үйдің минималды қабаты бойынша\n" +
                            "15. Пәтердің максималды қабаты бойынша\n" +
                            "16. Пәтердің мнималды қабаты бойынша\n"
                    );
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        System.out.println("Сіз іздейтің пәтердің максималды бағасы\n");
                        int price = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getCost() > price) {
                                System.out.println(apartment.toString());

                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 2) {
                        System.out.println("Сіз іздейтің пәтердің максималды бағасы\n");
                        int price = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getCost() < price) {
                                System.out.println(apartment.toString());

                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 3) {
                        System.out.println("Пәтердің максималды жалпы ауданың еңгізіңіз\n");
                        int area = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getTotalArea() < area) {
                                System.out.println(apartment.toString());

                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 4) {
                        System.out.println("Сізге іздейтің пәтердің бастапқы ауданңый  \n");
                        int area = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getTotalArea() > area) {
                                System.out.println(apartment.toString());

                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 5) {
                        System.out.println("Сізге іздейтің пәтердің бастапқы тұрғын ауданңый  \n");
                        int livingarea = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getLivingArea() > livingarea) {
                                System.out.println(apartment.toString());

                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 6) {
                        System.out.println("Сізге іздейтің пәтердің максималды тұрғын ауданңый  \n");
                        int livingarea = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getLivingArea() < livingarea) {
                                System.out.println(apartment.toString());

                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 7) {
                        for (Apartment apartment : apartments) {
                            if (apartment.isExistLoggia() == true) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 8) {
                        for (Apartment apartment : apartments) {
                            if (apartment.isExistLoggia() == false) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 9) {
                        for (Apartment apartment : apartments) {
                            if (apartment.isBathroomConnected() == true) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 10) {
                        for (Apartment apartment : apartments) {
                            if (apartment.isExistBathroom() == true) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 11) {
                        for (Apartment apartment : apartments) {
                            if (apartment.isPanel() == true) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 12) {
                        for (Apartment apartment : apartments) {
                            if (apartment.isBrick() == true) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 13) {
                        System.out.println("Сіз іздейтің үйдің максималды қабаты\n");
                        int totalLevel = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getTotalLevels() < totalLevel) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 14) {
                        System.out.println("Сіз іздейтің үйдің минималды қабаты\n");
                        int totalLevel = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getTotalLevels() > totalLevel) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }
                    if (ch == 15) {
                        System.out.println("Сіз іздейтің пәтердің максималды қабаты\n");
                        int totaltotal = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getLevelOfApartment() < totaltotal) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;
                    }

                    if (ch == 16) {
                        System.out.println("Сіз іздейтің пәтердің минималды қабаты\n");
                        int total = sc.nextInt();
                        for (Apartment apartment : apartments) {
                            if (apartment.getLevelOfApartment() > total) {
                                System.out.println(apartment.toString());
                            } else System.out.println("Бұл пәтер параметірге сай емес");
                        }
                        break;

                    }
                default: break;
            }
        } while (menu != 0);
    }
}