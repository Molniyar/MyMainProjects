import test1.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WalkAndBuld {
    public static void main(String[] args) throws Exception {
        final boolean[] timersRun = {true};

        final boolean[] toGoBack = {false};
        final int[] darkness = {0};

        final boolean[] canProcessKey = {true};
        final boolean[] canProcessMouse = {true};

        final int[] health = {9};
        final int[] food = {9};
        PolygonArt heartArt = new PolygonArt(new Polygon[]{new Polygon(new int[]{4, 1, 1, 2, 3, 4, 5, 6, 7, 7}, new int[]{7, 4, 3, 2, 2, 3, 2, 2, 3, 4}, 10)}, new Color[]{new Color(255, 0, 0)});
        PolygonArt foodArt = new PolygonArt(new Polygon[]{new Polygon(new int[]{1, 1, 2, 3, 2}, new int[]{7, 6, 5, 6, 7}, 5), new Polygon(new int[]{2, 2, 4, 5, 6, 6, 4, 3}, new int[]{5, 4, 2, 2, 3, 4, 6, 6}, 8), new Polygon(new int[]{4, 4, 5, 6, 6, 5}, new int[]{3, 2, 2, 3, 4, 4}, 6)}, new Color[]{new Color(170, 180, 60), new Color(170, 120, 0), new Color(180, 60, 0)});
        PolygonArt voidHeartArt = new PolygonArt(new Polygon[]{new Polygon(new int[]{4, 1, 1, 2, 3, 4, 5, 6, 7, 7}, new int[]{7, 4, 3, 2, 2, 3, 2, 2, 3, 4}, 10)}, new Color[]{new Color(0, 0, 0, 100)});
        PolygonArt voidFoodArt = new PolygonArt(new Polygon[]{new Polygon(new int[]{1, 1, 2, 2, 4, 5, 6, 6, 4, 3, 2}, new int[]{7, 6, 5, 4, 2, 2, 3, 4, 6, 6, 7}, 11)}, new Color[]{new Color(0, 0, 0, 100)});

        HashMap<String, Integer> items_ = WaBMethods.getItemsHashMap();

        //String[] names        = {"air","oak log","leaves\nblock","leaves","rocks","stone","magnetite","planks","stick","apple","sapling","crafting table","iron ore","iron ingot","wooden pickaxe","stone pickaxe","iron pickaxe"};

        boolean[] areWalkable = {true, false, false, true, true, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        boolean[] areTurnable = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true,true};
        int[] strengths = {0, 5, 2, 1, 2, 8, 10, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        PolygonArt[] blocks = {
                null,
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0, 0, 8, 8}, new int[]{0, 8, 8, 0}, 4), new Polygon(new int[]{1, 1, 7, 7}, new int[]{1, 7, 7, 1}, 4)}, new Color[]{new Color(130, 70, 0), new Color(200, 130, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0, 0, 8, 8}, new int[]{0, 8, 8, 0}, 4), new Polygon(new int[]{4, 4, 5, 6, 6, 5}, new int[]{2, 1, 0, 0, 1, 2}, 6), new Polygon(new int[]{2, 2, 3, 4, 4, 3}, new int[]{5, 4, 3, 3, 4, 5}, 6), new Polygon(new int[]{5, 5, 6, 7, 7, 6}, new int[]{7, 6, 5, 5, 6, 7}, 6), new Polygon(new int[]{1, 1, 2, 3, 3, 2}, new int[]{3, 2, 1, 1, 2, 3}, 6), new Polygon(new int[]{5, 5, 6, 7, 7, 6}, new int[]{4, 3, 2, 2, 3, 4}, 6), new Polygon(new int[]{2, 2, 3, 4, 4, 3}, new int[]{7, 6, 5, 5, 6, 7}, 6)}, new Color[]{new Color(0, 200, 0, 120), new Color(0, 160, 0, 200), new Color(0, 200, 0, 200), new Color(0, 180, 0, 200), new Color(0, 160, 0), new Color(0, 200, 0), new Color(0, 180, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{1, 1, 2, 3, 3, 2}, new int[]{3, 2, 1, 1, 2, 3}, 6), new Polygon(new int[]{5, 5, 6, 7, 7, 6}, new int[]{4, 3, 2, 2, 3, 4}, 6), new Polygon(new int[]{2, 2, 3, 4, 4, 3}, new int[]{7, 6, 5, 5, 6, 7}, 6)}, new Color[]{new Color(0, 160, 0), new Color(0, 200, 0), new Color(0, 180, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{1, 1, 2, 4, 5, 5}, new int[]{6, 4, 3, 3, 4, 6}, 6), new Polygon(new int[]{4, 4, 5, 6, 7, 7}, new int[]{7, 6, 5, 5, 6, 7}, 6)}, new Color[]{new Color(123, 123, 123), new Color(134, 134, 134)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0, 0, 8, 8}, new int[]{0, 8, 8, 0}, 4), new Polygon(new int[]{0, 1, 4, 3}, new int[]{2, 1, 1, 2}, 4), new Polygon(new int[]{4, 5, 8, 7}, new int[]{4, 3, 3, 4}, 4)}, new Color[]{new Color(123, 123, 123), new Color(134, 134, 134), new Color(140, 140, 140)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0, 0, 8, 8}, new int[]{0, 8, 8, 0}, 4), new Polygon(new int[]{1, 2, 3, 2}, new int[]{2, 1, 2, 3}, 4), new Polygon(new int[]{4, 5, 8, 7}, new int[]{4, 3, 3, 4}, 4)}, new Color[]{new Color(150, 100, 41), new Color(20, 0, 30), new Color(140, 100, 80)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0, 0, 8, 8}, new int[]{0, 2, 2, 0}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{2, 4, 4, 2}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{4, 6, 6, 4}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{6, 8, 8, 6}, 4)}, new Color[]{new Color(230, 160, 0), new Color(200, 130, 0), new Color(220, 150, 0), new Color(190, 120, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2, 1, 1, 6, 7, 7}, new int[]{7, 7, 6, 1, 1, 2}, 6)}, new Color[]{new Color(120, 80, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2, 1, 1, 2, 4, 5, 5, 4}, new int[]{7, 6, 4, 3, 3, 4, 6, 7}, 8), new Polygon(new int[]{3, 4, 6, 5}, new int[]{3, 2, 2, 3}, 4), new Polygon(new int[]{2, 2, 3}, new int[]{5, 4, 4}, 3), new Polygon(new int[]{2, 1, 3, 4, 4, 5, 5, 4}, new int[]{7, 6, 6, 5, 3, 4, 6, 7}, 8)}, new Color[]{new Color(200, 0, 0), new Color(0, 130, 0), new Color(255, 130, 170), new Color(160, 0, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0, 0, 2, 2}, new int[]{8, 0, 0, 8}, 4), new Polygon(new int[]{6, 6, 8, 8}, new int[]{8, 0, 0, 8}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{2, 0, 0, 2}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{6, 8, 8, 6}, 4), new Polygon(new int[]{3, 2, 2, 4, 6, 6, 5}, new int[]{5, 4, 3, 1, 3, 4, 5}, 7), new Polygon(new int[]{4, 3, 4, 5}, new int[]{3, 4, 5, 4}, 4)}, new Color[]{new Color(120, 60, 0), new Color(120, 60, 0), new Color(100, 50, 0), new Color(100, 50, 0), new Color(255, 200, 0), new Color(255, 140, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2, 1, 1, 2, 4, 5, 5, 4}, new int[]{4, 3, 2, 1, 1, 2, 3, 4}, 8), new Polygon(new int[]{5, 4, 4, 5, 6, 7, 7, 6}, new int[]{5, 4, 3, 2, 2, 3, 4, 5}, 8), new Polygon(new int[]{3, 3, 4, 4}, new int[]{7, 3, 3, 7}, 4), new Polygon(new int[]{4, 4, 5, 6}, new int[]{6, 5, 4, 4}, 4)}, new Color[]{new Color(0, 160, 0), new Color(0, 130, 0), new Color(120, 60, 0), new Color(110, 50, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{1,1,2,2}, new int[]{6,3,4,7}, 4), new Polygon(new int[]{3,3,4,4}, new int[]{6,3,2,5}, 4), new Polygon(new int[]{5,5,6,6}, new int[]{7,4,3,6}, 4)}, new Color[]{new Color(0, 150, 0), new Color(0, 140, 0), new Color(0, 125, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2,4,4}, new int[]{5,3,5}, 3), new Polygon(new int[]{4,4,5}, new int[]{5,3,5}, 3), new Polygon(new int[]{3,2,4}, new int[]{6,5,5}, 3), new Polygon(new int[]{3,4,5}, new int[]{6,5,5}, 3)}, new Color[]{new Color(200, 70, 0), new Color(123, 70, 40), new Color(80, 40, 0), new Color(60, 20, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2,4,5,3}, new int[]{4,3,4,5}, 4), new Polygon(new int[]{3,3,5,5}, new int[]{6,5,4,5}, 4), new Polygon(new int[]{2,2,3,3}, new int[]{5,4,5,6}, 4)}, new Color[]{new Color(180, 180, 180), new Color(150, 150, 150), new Color(120, 120, 120)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{3,2,2,3,4,5,5,4}, new int[]{6,5,4,3,3,4,5,6}, 8), new Polygon(new int[]{5,4,5,6}, new int[]{6,5,4,5}, 4)}, new Color[]{new Color(20, 20, 20), new Color(50, 50, 50)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{3,3,4,4}, new int[]{7,4,4,7}, 4), new Polygon(new int[]{3,2,4,5,5,4}, new int[]{4,3,1,2,3,4}, 6), new Polygon(new int[]{3,3,4,4}, new int[]{4,3,3,4}, 4)}, new Color[]{new Color(100, 50, 20), new Color(200, 130, 0,150), new Color(160, 80, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0, 0, 8, 8}, new int[]{0, 2, 2, 5}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{2, 4, 4, 2}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{4, 6, 6, 4}, 4), new Polygon(new int[]{0, 0, 8, 8}, new int[]{6, 8, 8, 6}, 4)}, new Color[]{new Color(230, 160, 0), new Color(200, 130, 0), new Color(220, 150, 0), new Color(190, 60, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0,0,5,6,6,1}, new int[]{8,7,2,2,3,8}, 6), new Polygon(new int[]{2,4,7,7,6,4}, new int[]{1,1,4,6,4,2}, 6)}, new Color[]{new Color(120, 80, 0), new Color(140, 100, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0,0,5,6,6,1}, new int[]{8,7,2,2,3,8}, 6), new Polygon(new int[]{2,2,4,5,5,6,5,4}, new int[]{3,2,0,0,2,3,4,3}, 8)}, new Color[]{new Color(120, 80, 0), new Color(140, 100, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0,0,5,6,6,1}, new int[]{8,7,2,2,3,8}, 6), new Polygon(new int[]{2,4,7,7,6,4}, new int[]{1,1,4,6,4,2}, 6)}, new Color[]{new Color(120, 80, 0), new Color(100, 100, 100)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0,0,5,6,6,1}, new int[]{8,7,2,2,3,8}, 6), new Polygon(new int[]{2,2,4,5,5,6,5,4}, new int[]{3,2,0,0,2,3,4,3}, 8)}, new Color[]{new Color(120, 80, 0), new Color(100, 100, 100)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0,0,5,6,6,1}, new int[]{8,7,2,2,3,8}, 6), new Polygon(new int[]{2,4,7,7,6,4}, new int[]{1,1,4,6,4,2}, 6)}, new Color[]{new Color(120, 80, 0), new Color(170, 170, 170)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{0,0,5,6,6,1}, new int[]{8,7,2,2,3,8}, 6), new Polygon(new int[]{2,2,4,5,5,6,5,4}, new int[]{3,2,0,0,2,3,4,3}, 8)}, new Color[]{new Color(120, 80, 0), new Color(170, 170, 170)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{3,3,4,4}, new int[]{6,5,4,5}, 4), new Polygon(new int[]{3,3,4}, new int[]{6,5,5}, 3)}, new Color[]{new Color(0, 160, 0), new Color(110, 100, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{3,3,4,4}, new int[]{7,5,4,6}, 4), new Polygon(new int[]{5,5,6,6}, new int[]{7,6,5,6}, 4)}, new Color[]{new Color(0, 160, 0), new Color(0, 160, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{1,1,2,2}, new int[]{6,4,5,7}, 4), new Polygon(new int[]{3,3,4,4}, new int[]{7,4,3,6}, 4), new Polygon(new int[]{5,5,6,6}, new int[]{7,5,4,6}, 4)}, new Color[]{new Color(70, 140, 0), new Color(60, 140, 0), new Color(60, 130, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{1,1,2,2}, new int[]{6,3,4,7}, 4), new Polygon(new int[]{3,3,4,4}, new int[]{7,3,2,6}, 4), new Polygon(new int[]{5,5,6,6}, new int[]{7,4,3,6}, 4)}, new Color[]{new Color(140, 170, 0), new Color(140, 160, 0), new Color(140, 140, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{1,1,2,2}, new int[]{6,2,3,7}, 4), new Polygon(new int[]{3,3,4,4}, new int[]{7,2,1,6}, 4), new Polygon(new int[]{5,5,6,6}, new int[]{7,3,2,6}, 4)}, new Color[]{new Color(220, 160, 0), new Color(230, 160, 0), new Color(240, 160, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2,3,3,2,6,5,5,6}, new int[]{7,5,4,2,2,4,5,7}, 8), new Polygon(new int[]{4,4,5,6,5,5,6}, new int[]{7,4,2,2,4,5,7}, 7), new Polygon(new int[]{3,3,5,5}, new int[]{5,4,4,5}, 4)}, new Color[]{new Color(220,160,0), new Color(140, 110, 0), new Color(180, 60, 60)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{3,2,2,3,5,6,6,5}, new int[]{6,5,4,3,3,4,5,6}, 8), new Polygon(new int[]{3,4,5,6,6,5}, new int[]{6,5,5,4,5,6}, 6)}, new Color[]{new Color(230,200,100), new Color(160, 140, 70)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2,2,4,6,6,3}, new int[]{6,4,2,2,3,6}, 6), new Polygon(new int[]{2,3,3}, new int[]{4,3,5}, 3), new Polygon(new int[]{3,4,4}, new int[]{3,2,4}, 3), new Polygon(new int[]{4,5,5}, new int[]{2,2,3}, 3)}, new Color[]{new Color(136, 103, 0, 255), new Color(83, 68, 0), new Color(94, 78, 0), new Color(104, 87, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{4,3,5}, new int[]{4,3,3}, 3), new Polygon(new int[]{4,5,6}, new int[]{4,3,4}, 3), new Polygon(new int[]{3,3,4}, new int[]{5,3,4}, 3), new Polygon(new int[]{3,4,5}, new int[]{5,4,6}, 3), new Polygon(new int[]{4,5,6}, new int[]{4,6,4}, 3)}, new Color[]{new Color(200, 131, 90, 255), new Color(255, 121, 38), new Color(56, 166, 101), new Color(149, 104, 36), new Color(36, 96, 71)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2,4,5,3}, new int[]{4,3,4,5}, 4), new Polygon(new int[]{3,3,5,5}, new int[]{6,5,4,5}, 4), new Polygon(new int[]{2,2,3,3}, new int[]{5,4,5,6}, 4)}, new Color[]{new Color(255, 143, 82), new Color(221, 88, 37), new Color(161, 79, 35)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{3,3,4,4}, new int[]{7,0,0,7}, 4), new Polygon(new int[]{4,4,5,5}, new int[]{7,0,0,7}, 4), new Polygon(new int[]{1,1,4,4}, new int[]{4,3,3,4}, 4), new Polygon(new int[]{1,1,4,4}, new int[]{5,4,4,5}, 4), new Polygon(new int[]{5,5,7,7}, new int[]{4,3,3,4}, 4), new Polygon(new int[]{5,5,7,7}, new int[]{5,4,4,5}, 4), new Polygon(new int[]{2,4,6}, new int[]{3,1,3}, 3)}, new Color[]{new Color(255, 143, 82, 255), new Color(221, 88, 37), new Color(255, 143, 82), new Color(221, 88, 37),new Color(255, 143, 82), new Color(221, 88, 37), new Color(0, 0, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{3,3,4,4}, new int[]{7,0,0,7}, 4), new Polygon(new int[]{4,4,5,5}, new int[]{7,0,0,7}, 4), new Polygon(new int[]{1,1,4,4}, new int[]{4,3,3,4}, 4), new Polygon(new int[]{1,1,4,4}, new int[]{5,4,4,5}, 4), new Polygon(new int[]{5,5,7,7}, new int[]{4,3,3,4}, 4), new Polygon(new int[]{5,5,7,7}, new int[]{5,4,4,5}, 4), new Polygon(new int[]{2,4,6}, new int[]{3,1,3}, 3)}, new Color[]{new Color(255, 143, 82, 255), new Color(221, 88, 37), new Color(255, 143, 82), new Color(221, 88, 37),new Color(255, 143, 82), new Color(221, 88, 37), new Color(255, 0, 0)}),
                new PolygonArt(new Polygon[]{new Polygon(new int[]{2,2,4,6,6,3}, new int[]{6,4,2,2,3,6}, 6), new Polygon(new int[]{2,3,3}, new int[]{4,3,5}, 3), new Polygon(new int[]{3,4,4}, new int[]{3,2,4}, 3), new Polygon(new int[]{4,5,5}, new int[]{2,2,3}, 3)}, new Color[]{new Color(136, 103, 0, 255), new Color(83, 68, 0), new Color(94, 78, 0), new Color(104, 87, 0)}),
        };

        final boolean[] showCraftingMenu = {false};

        final int[][] blockReputting = {{0, 0}};
        final boolean[] showInventory = {false};
        int[][][] inventory = new int[4][6][2];
        inventory[0][0]= new int[]{34,16};
        inventory[0][1]= new int[]{35,16};

        PolygonArt playerView = new PolygonArt(new Polygon[]{new Polygon(new int[]{2,1,1,2,6,7,7,6},new int[]{7,6,2,1,1,2,6,7},8),new Polygon(new int[]{2,1,1,7,7,6},new int[]{7,6,4,4,6,7},6),new Polygon(new int[]{2,2,3,3},new int[]{3,2,2,3},4),new Polygon(new int[]{5,5,6,6},new int[]{3,2,2,3},4)},new Color[]{new Color(255, 200, 1),new Color(123, 80, 1),new Color(0, 60, 120),new Color(0, 60, 120)});//255, 200, 1

        int l = 16;

        int[][] world = new int[l][l];

        int[] currentBlock = {-1, -1, -1};
        final int[] choosenBlock = {1};

        int[] player = {6, 6, 0};

        int[] worldView = {0, 0};

//20
        WaBMethods.generateCliffs(world, items_.get("stone"), items_.get("stone"), 2, 5, 30, 5, 30, 0, 0, 0, 0);
        WaBMethods.generateCliffs(world, items_.get("stone"), items_.get("stone"), 0, 0, 25, 0, 25, 25, 0, 25, 0);
        WaBMethods.generateCliffs(world, items_.get("rocks"), items_.get("stone"), 0, 0, 70, 0, 70, 70, 0, 70, 0);
        WaBMethods.generateTrees(world, 3, items_.get("oak_log"), items_.get("leaves_block"), items_.get("leaves"));
        WaBMethods.throwBlocks(world, items_.get("magnetite"), items_.get("stone"), 15);
        WaBMethods.throwBlocks(world, items_.get("grass"), 0, 5);
        WaBMethods.generateCliffs(world,6,6,5,0,0,20,0,20,20,0,20,0);


        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 816);


        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                int num = Math.min(getWidth(), getHeight());
                super.paintComponent(g);
                int x = num / 16;
                int y = num / 16;

                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < 16; j++) {
                        int coordX = num / 16 * j;
                        int coordY = num / 16 * i;

                        if (blocks[world[i][j]&255] != null) {
                            blocks[world[i][j]&255].drawWithTurn(g, coordX, coordY, x, y,(world[i][j]>>8)&3);
                        }

                        if (i == player[0] && j == player[1]) {
                            playerView.drawWithTurn(g,coordX,coordY,x,y,player[2]);
                        }

                        g.setColor(new Color(0, 0, 0, WaBMethods.getDarkness(world, j, i, Math.clamp(darkness[0], 0, 200), areWalkable)));
                        g.fillRect(coordX, coordY, x, y);
                    }
                }

                int X = num / 8;
                int Y = num / 8;

                for (int j = 0; j < inventory[3].length; j++) {
                    int i = 3;
                    int coordX = num / 8 * (j + 1);
                    int coordY = num / 8 * (i + 4);
                    if (choosenBlock[0] == j) g.setColor(new Color(255, 255, 255, 100));
                    else g.setColor(new Color(200, 200, 200, 100));

                    g.fillRect(coordX, coordY, X, Y);
                    g.setColor(new Color(100, 100, 100));
                    g.drawRect(coordX, coordY, X, Y);
                    if (blocks[inventory[i][j][0]] != null) {
                        blocks[inventory[i][j][0]].drawTransparent(g, coordX, coordY, X, Y);
                    }
                    if (inventory[i][j][1] != 1 && inventory[i][j][0] != 0) {
                        g.setColor(Color.BLACK);
                        g.drawString(Integer.toString(inventory[i][j][1]), coordX, coordY + Y);
                    }
                }


                int X_ = num / 24;
                int Y_ = num / 24;
                for (int j = 0; j < 9; j++) {
                    int i = 3;
                    int coordX = num / 24 * (j + 3);
                    int coordY = num / 8 * (i + 4) - num / 24;

                    if (health[0] > j) {
                        heartArt.draw(g, coordX, coordY, X_, Y_);
                        continue;
                    }
                    voidHeartArt.draw(g, coordX, coordY, X_, Y_);
                }
                for (int j = 0; j < 9; j++) {
                    int i = 3;
                    int coordX = num / 2 + num / 24 * (9 - j - 1);
                    int coordY = num / 8 * (i + 4) - num / 24;

                    if (food[0] > j) {
                        foodArt.draw(g, coordX, coordY, X_, Y_);
                        continue;
                    }
                    voidFoodArt.draw(g, coordX, coordY, X_, Y_);
                }


                if (showInventory[0]) {
                    for (int i = 0; i < inventory.length; i++) {
                        for (int j = 0; j < inventory[0].length; j++) {
                            int coordX = num / 8 * (j + 1);
                            int coordY = num / 8 * (i + 2);
                            g.setColor(new Color(0, 0, 0, 100));
                            g.fillRect(coordX + 20, coordY + 20, X, Y);
                        }
                    }
                    for (int i = 0; i < inventory.length; i++) {
                        for (int j = 0; j < inventory[0].length; j++) {
                            int coordX = num / 8 * (j + 1);
                            int coordY = num / 8 * (i + 2);
                            g.setColor(new Color(200, 200, 200));
                            g.fillRect(coordX, coordY, X, Y);
                            g.setColor(new Color(100, 100, 100));
                            g.drawRect(coordX, coordY, X, Y);
                            if (blocks[inventory[i][j][0]] != null) {
                                blocks[inventory[i][j][0]].draw(g, coordX, coordY, X, Y);
                            }
                            if (inventory[i][j][1] != 1 && inventory[i][j][0] != 0) {
                                g.setColor(Color.BLACK);
                                g.drawString(Integer.toString(inventory[i][j][1]), coordX, coordY + Y);
                            }
                        }
                    }
                }

                int x_ = num/8*6;
                int y_ = num/8;
                for (int i = 0; i < inventory.length; i++) {
                    if (!showCraftingMenu[0]) {break;}
                    int coordX = num / 8;
                    int coordY = num / 8 * (i + 2);

                    g.setColor(new Color(200, 200, 200));
                    g.fillRect(coordX, coordY, x_, y_);
                    g.setColor(new Color(100, 100, 100));
                    g.drawRect(coordX, coordY, x_, y_);
                    for (int j = 0; j < inventory[0].length; j++) {


                        g.setColor(new Color(200, 200, 200));
                        g.fillRect(coordX, coordY, X, Y);
                        g.setColor(new Color(100, 100, 100));
                        g.drawRect(coordX, coordY, X, Y);
                        if (blocks[inventory[i][j][0]] != null) {
                            blocks[inventory[i][j][0]].draw(g, coordX, coordY, X, Y);
                        }
                        if (inventory[i][j][1] != 1 && inventory[i][j][0] != 0) {
                            g.setColor(Color.BLACK);
                            g.drawString(Integer.toString(inventory[i][j][1]), coordX, coordY + Y);
                        }
                    }
                }

                if (health[0] == 0) {
                    g.setColor(new Color(255, 0, 0, 100));
                    g.fillRect(0, 0, 1000, 1000);
                    g.setColor(new Color(0, 0, 0));
                    g.drawString("Вы умерли", 0, 0);
                    timersRun[0] = false;
                }
            }
        };

        frame.add(panel);
        panel.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        panel.requestFocusInWindow();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER&&!timersRun[0]){
                    health[0] = 9;
                    timersRun[0] = true;
                }
                if (!canProcessKey[0]) {
                    return;
                }
                canProcessKey[0] = false;

                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_W -> {
                        if (player[0] <= 0) {break;}
                        if (player[2] == 0 && areWalkable[world[player[0] - 1][player[1]]&255]) {
                            player[0] = Math.clamp(player[0] - 1, 0, l - 1);
                            if (MolniyarMethod.random(1)){food[0]--;}
                        } else player[2] = 0;
                    }
                    case KeyEvent.VK_S -> {
                        if (player[0] >= l - 1) {break;}
                        if (player[2] == 2 && areWalkable[world[player[0] + 1][player[1]]&255]) {
                            player[0] = Math.clamp(player[0] + 1, 0, l - 1);
                            if (MolniyarMethod.random(1)){food[0]--;}
                        } else player[2] = 2;
                    }
                    case KeyEvent.VK_A -> {
                        if (player[1] <= 0) {break;}
                        if (player[2] == 3 && areWalkable[world[player[0]][player[1] - 1]&255]) {
                            player[1] = Math.clamp(player[1] - 1, 0, l - 1);
                            if (MolniyarMethod.random(1)){food[0]--;}
                        } else player[2] = 3;
                    }
                    case KeyEvent.VK_D -> {
                        if (player[1] >= l - 1) {break;}
                        if (player[2] == 1 && areWalkable[world[player[0]][player[1] + 1]&255]) {
                            player[1] = Math.clamp(player[1] + 1, 0, l - 1);
                            if (MolniyarMethod.random(1)){food[0]--;}
                        } else player[2] = 1;
                    }
                    case KeyEvent.VK_1 -> choosenBlock[0] = 0;
                    case KeyEvent.VK_2 -> choosenBlock[0] = 1;
                    case KeyEvent.VK_3 -> choosenBlock[0] = 2;
                    case KeyEvent.VK_4 -> choosenBlock[0] = 3;
                    case KeyEvent.VK_5 -> choosenBlock[0] = 4;
                    case KeyEvent.VK_6 -> choosenBlock[0] = 5;
                    case KeyEvent.VK_E -> showInventory[0] = !showInventory[0];

                    case KeyEvent.VK_N -> darkness[0] = 400;
                    case KeyEvent.VK_L -> darkness[0] = -200;
                }
                panel.updateUI();
            }
        });


        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                try {
                    switch (e.getButton()) {
                        case MouseEvent.BUTTON1 -> {
                            if (!canProcessMouse[0]) {
                                return;
                            }
                            canProcessMouse[0] = false;

                            if (showInventory[0]) {
                                int num = Math.min(panel.getWidth(), panel.getHeight());
                                if (blockReputting[0][0] != inventory[y / (num / 8) - 2][x / (num / 8) - 1][0]) {
                                    int[] keep = inventory[y / (num / 8) - 2][x / (num / 8) - 1];
                                    inventory[y / (num / 8) - 2][x / (num / 8) - 1] = blockReputting[0];
                                    blockReputting[0] = keep;
                                    if (blockReputting[0][1] == 0) {
                                        blockReputting[0][0] = 0;
                                    }
                                    break;
                                }
                                //int[] keep = inventory[y/(num/8)-2][x/(num/8)-1];
                                inventory[y / (num / 8) - 2][x / (num / 8) - 1][1] = inventory[y / (num / 8) - 2][x / (num / 8) - 1][1] + blockReputting[0][1];
                                blockReputting[0] = new int[]{0, 0};

                                WaBMethods.checkInventoryForAir(inventory);

                                break;
                            }

                            int[] coords = {player[0], player[1]};
                            switch (player[2]) {
                                case 0 -> coords[0]--;
                                case 1 -> coords[1]++;
                                case 2 -> coords[0]++;
                                case 3 -> coords[1]--;
                            }

                            if (currentBlock[0] != coords[0] || currentBlock[1] != coords[1]) {
                                currentBlock[0] = coords[0];
                                currentBlock[1] = coords[1];
                                currentBlock[2] = strengths[world[coords[0]][coords[1]]&255];
                            }

                            currentBlock[2] -= WaBMethods.breakStrength(world[currentBlock[0]][currentBlock[1]]&255,inventory[3][choosenBlock[0]][0]);//<--{hand strength}; there will be different strengths for different blocks

                            if (currentBlock[2] <= 0) {
                                int[] loot = WaBMethods.getLoot(world[currentBlock[0]][currentBlock[1]]&255, inventory[3][choosenBlock[0]][0]);
                                boolean putLoot = true;
                                for (int item : loot) if (!WaBMethods.canPlaceItem(inventory, item)) putLoot = false;
                                if (putLoot) {
                                    for (int item : loot) {
                                        WaBMethods.placeItem(inventory, item);
                                    }
                                    world[currentBlock[0]][currentBlock[1]] = 0;
                                }
                                if (inventory[3][choosenBlock[0]][1]==1){
                                    inventory[3][choosenBlock[0]][0] = WaBMethods.breakItem(inventory[3][choosenBlock[0]&255][0]);
                                }
                                currentBlock[0] = -1;
                                currentBlock[1] = -1;
                            }
                        }
                        case MouseEvent.BUTTON2 -> {
                            if (!canProcessMouse[0]) {return;}
                            canProcessMouse[0] = false;

                            switch (inventory[3][choosenBlock[0]][0]){
                                case 9 -> {
                                    if (food[0]==9){break;}
                                    inventory[3][choosenBlock[0]][1]--;
                                    food[0]+=1;
                                }
                                case 31 -> {
                                    if (food[0]==9){break;}
                                    inventory[3][choosenBlock[0]][1]--;
                                    food[0]+=2;
                                }
                                case 1 -> {
                                    if (WaBMethods.canPlaceItem(inventory,7)){
                                        WaBMethods.placeItem(inventory,7);
                                        WaBMethods.placeItem(inventory,7);
                                        WaBMethods.placeItem(inventory,7);
                                        WaBMethods.placeItem(inventory,7);
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                            }
                            WaBMethods.checkInventoryForAir(inventory);
                        }
                        case MouseEvent.BUTTON3 -> {
                            if (showInventory[0]) {
                                int num = Math.min(panel.getWidth(), panel.getHeight());
                                int[] keep = {0, 0};
                                if (blockReputting[0][0] == 0 && blockReputting[0][1] == 0) {
                                    blockReputting[0][0] = inventory[y / (num / 8) - 2][x / (num / 8) - 1][0];
                                    blockReputting[0][1] = inventory[y / (num / 8) - 2][x / (num / 8) - 1][1] / 2;
                                    inventory[y / (num / 8) - 2][x / (num / 8) - 1][1] = inventory[y / (num / 8) - 2][x / (num / 8) - 1][1] - blockReputting[0][1];
                                    if (blockReputting[0][1] == 0) {blockReputting[0][0] = 0;}
                                    break;
                                }
                                if (blockReputting[0][0] > 0 && blockReputting[0][1] > 0) {
                                    if (inventory[y / (num / 8) - 2][x / (num / 8) - 1][0] != blockReputting[0][0] && inventory[y / (num / 8) - 2][x / (num / 8) - 1][0] != 0) {break;}
                                    inventory[y / (num / 8) - 2][x / (num / 8) - 1] = new int[]{blockReputting[0][0], inventory[y / (num / 8) - 2][x / (num / 8) - 1][1] + 1};
                                    if (blockReputting[0][1] == 0) {blockReputting[0][0] = 0;}
                                    blockReputting[0][1]--;
                                    break;
                                }
                                WaBMethods.checkInventoryForAir(inventory);
                                break;
                            }

                            int[] coords = {player[0], player[1]};
                            switch (player[2]) {
                                case 0 -> coords[0]--;
                                case 1 -> coords[1]++;
                                case 2 -> coords[0]++;
                                case 3 -> coords[1]--;
                            }
                            switch (world[coords[0]][coords[1]]&255){
                                case 0 -> {
                                    world[coords[0]][coords[1]] = inventory[3][choosenBlock[0]][0];
                                    if (areTurnable[world[coords[0]][coords[1]]]){
                                        world[coords[0]][coords[1]] |= (player[2]<<8);
                                    }
                                    inventory[3][choosenBlock[0]][1]--;
                                }
                                case 8 -> {
                                    int block = 0;
                                    switch (inventory[3][choosenBlock[0]][0]){
                                        case 15 -> block = 16;
                                        case 7  -> block = 18;
                                        case 5  -> block = 20;
                                        case 14 -> block = 22;
                                    }
                                    if (block != 0){
                                        world[coords[0]][coords[1]] = block;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }

                                }
                                case 1 -> {
                                    if (inventory[3][choosenBlock[0]][0]==16) {
                                        world[coords[0]][coords[1]] = 10;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                                case 10 -> {
                                    if (inventory[3][choosenBlock[0]][0]==13) {
                                        if (WaBMethods.canPlaceItem(inventory,14)){
                                            WaBMethods.placeItem(inventory,14);
                                            inventory[3][choosenBlock[0]][1]--;
                                        }
                                    }
                                    if (inventory[3][choosenBlock[0]][0]==30) {
                                        if (WaBMethods.canPlaceItem(inventory,31)){
                                            WaBMethods.placeItem(inventory,31);
                                            inventory[3][choosenBlock[0]][1]--;
                                        }
                                    }
                                    if (inventory[3][choosenBlock[0]][0]==32) {
                                        if (WaBMethods.canPlaceItem(inventory,33)){
                                            WaBMethods.placeItem(inventory,33);
                                            inventory[3][choosenBlock[0]][1]--;
                                        }
                                    }
                                }
                                case 14 -> {
                                    if (inventory[3][choosenBlock[0]][0]==16) {
                                        world[coords[0]][coords[1]] = 17;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                                case 18 -> {
                                    if (inventory[3][choosenBlock[0]][0]==7) {
                                        world[coords[0]][coords[1]] = 19;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                                case 20 -> {
                                    if (inventory[3][choosenBlock[0]][0]==5) {
                                        world[coords[0]][coords[1]] = 21;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                                case 22 -> {
                                    if (inventory[3][choosenBlock[0]][0]==14) {
                                        world[coords[0]][coords[1]] = 23;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                                case 29 -> {
                                    if (inventory[3][choosenBlock[0]][0]==29) {
                                        world[coords[0]][coords[1]] = 30;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                                case 33 -> {
                                    if (inventory[3][choosenBlock[0]][0]==33) {
                                        world[coords[0]][coords[1]] = 34;
                                        inventory[3][choosenBlock[0]][1]--;
                                    }
                                }
                            }
                            if (blockReputting[0][1] == 0) {blockReputting[0][0] = 0;}
                            WaBMethods.checkInventoryForAir(inventory);
                        }
                    }
                } catch (NullPointerException exception) {
                    new PlaySound("1", 1, 500, 20);
                }
                panel.updateUI();
            }
        });


        Timer updateKey = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canProcessKey[0] = true; // Разрешаем обработку нажатий
            }
        });

        Timer updateMouse = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canProcessMouse[0] = true; // Разрешаем обработку нажатий
            }
        });

        Timer update = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toGoBack[0]) {
                    darkness[0] -= 1;
                } else darkness[0] += 1;

                if (darkness[0] <= -100) {
                    toGoBack[0] = false;
                }
                if (darkness[0] >= 300) {
                    toGoBack[0] = true;
                }

                if (world[player[0]][player[1]] == 10) {health[0]--;}
                if (food[0] <= 6&&MolniyarMethod.random(1)) {food[0]--;}
                if (food[0] == 0) {health[0]--;}
                if (food[0] >= 9 && health[0] < 9 && MolniyarMethod.random(50)) {health[0]++;}
                food[0] = Math.clamp(food[0],0,9);
                health[0] = Math.clamp(health[0],0,9);

                WaBMethods.updateWorld(world, darkness[0]);

                WaBMethods.updateCopperCircuits(world);

                panel.updateUI();
            }
        });
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timersRun[0]){
                    update.start();
                    updateMouse.start();
                    updateKey.start();
                }
                else {
                    update.stop();
                    updateMouse.stop();
                    updateKey.stop();
                }
            }
        }).start();
    }
}
