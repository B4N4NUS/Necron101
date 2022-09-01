package com.bruh.wahaplayer;

import com.bruh.wahaplayer.models.Model;
import com.bruh.wahaplayer.phases.Phases;
import com.bruh.wahaplayer.protocols.Protocol;
import com.bruh.wahaplayer.rules.Rule;
import com.bruh.wahaplayer.weapons.Weapon;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    public static ArrayList<Model> models = new ArrayList<>();
    public static ArrayList<Rule> rules = new ArrayList<>();
    public static ArrayList<Weapon> weapons = new ArrayList<>();
    public static ArrayList<Protocol> protocols = new ArrayList<>();

    public static HashMap<String, Model> getModel = new HashMap<>();
    public static HashMap<String, Rule> getRules = new HashMap<>();
    public static HashMap<String, Weapon> getWeapons = new HashMap<>();


    public static void fetchData(String faction, MainActivity ma) {
        try {
            Model dummyModel = new Model();
            Rule dummyRule = new Rule();
            Weapon dummyWeapon = new Weapon();


            InputStream is;
            InputStreamReader isReader;
            //Creating a BufferedReader object
            BufferedReader reader ;
            StringBuilder sb ;
            String str;




            is = ma.getResources().openRawResource(R.raw.abilities);
            isReader = new InputStreamReader(is);
            //Creating a BufferedReader object
            reader = new BufferedReader(isReader);
            sb = new StringBuilder();
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }

            JSONArray jsonRules = new JSONArray(sb.toString());
            System.out.println(sb);

            for (int i = 0; i < jsonRules.length(); i++) {
                dummyRule.name = jsonRules.getJSONObject(i).getString("name");
                dummyRule.description = jsonRules.getJSONObject(i).getString("description");
                dummyRule.phase = parsePhase(jsonRules.getJSONObject(i).getString("phase"));

                rules.add(dummyRule);
                getRules.put(dummyRule.name, dummyRule);
                dummyRule = new Rule();
            }
            for(int i = 0 ; i < rules.size(); i++) {
                getRules.put(rules.get(i).name, rules.get(i));
            }





            is = ma.getResources().openRawResource(R.raw.weapons);
            isReader = new InputStreamReader(is);
            //Creating a BufferedReader object
            reader = new BufferedReader(isReader);
            sb = new StringBuilder();
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }

            JSONArray jsonWeapons = new JSONArray(sb.toString());
            System.out.println(sb);

            for (int i = 0; i < jsonWeapons.length(); i++) {
                dummyWeapon.name = jsonWeapons.getJSONObject(i).getString("name");
                dummyWeapon.range = jsonWeapons.getJSONObject(i).getString("range");
                dummyWeapon.type = jsonWeapons.getJSONObject(i).getString("type");
                dummyWeapon.s = jsonWeapons.getJSONObject(i).getString("s");
                dummyWeapon.ap = jsonWeapons.getJSONObject(i).getString("ap");
                dummyWeapon.d = jsonWeapons.getJSONObject(i).getString("d");
                dummyWeapon.abilities = jsonWeapons.getJSONObject(i).getString("abilities");

                weapons.add(dummyWeapon);
                dummyWeapon= new Weapon();
            }
            for(int i = 0 ; i < weapons.size(); i++) {
                getWeapons.put(weapons.get(i).name, weapons.get(i));
            }



            is = ma.getResources().openRawResource(R.raw.models);
            isReader = new InputStreamReader(is);
            //Creating a BufferedReader object
            reader = new BufferedReader(isReader);
            sb = new StringBuilder();
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            JSONArray jsonModels = new JSONArray(sb.toString());
            System.out.println(sb);

            for (int i = 0; i < jsonModels.length(); i++) {
                dummyModel.name = jsonModels.getJSONObject(i).getString("name");
                dummyModel.m = jsonModels.getJSONObject(i).getString("m");
                dummyModel.ws = jsonModels.getJSONObject(i).getString("ws");
                dummyModel.bs = jsonModels.getJSONObject(i).getString("bs");
                dummyModel.s = jsonModels.getJSONObject(i).getString("s");
                dummyModel.t = jsonModels.getJSONObject(i).getString("t");
                dummyModel.w = jsonModels.getJSONObject(i).getString("w");
                dummyModel.a = jsonModels.getJSONObject(i).getString("a");
                dummyModel.ld = jsonModels.getJSONObject(i).getString("ld");
                dummyModel.save = jsonModels.getJSONObject(i).getString("save");
                dummyModel.weapons = jsonModels.getJSONObject(i).getString("weapons").split(",");
                dummyModel.rules = jsonModels.getJSONObject(i).getString("rules").split(",");
                dummyModel.clean();

                models.add(dummyModel);
                getModel.put(dummyModel.name, dummyModel);
                dummyModel = new Model();
            }
            for(int i = 0 ; i < models.size(); i++) {
                getModel.put(models.get(i).name, models.get(i));
            }

            System.out.println(models.get(0).toString());
            System.out.println(models.get(1).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static Phases parsePhase(String raw) {
        switch (raw) {
            case "DEPLOYMENT": {
                return Phases.DEPLOYMENT;
            }
            case "COMMAND": {
                return Phases.COMMAND;
            }
            case "MOVEMENT": {
                return Phases.MOVEMENT;
            }
            case "PSYCKER": {
                return Phases.PSYCKER;
            }
            case "SHOOTING": {
                return Phases.SHOOTING;
            }
            case "ATTACK": {
                return Phases.ATTACK;
            }
            case "COMBAT": {
                return Phases.COMBAT;
            }
            case "MORALE": {
                return Phases.MORALE;
            }
            case "OPPONENT_COMMAND": {
                return Phases.OPPONENT_COMMAND;
            }
            case "OPPONENT_MOVEMENT": {
                return Phases.OPPONENT_MOVEMENT;
            }
            case "OPPONENT_PSYCKER":{
                return Phases.OPPONENT_PSYCKER;
            }
            case "OPPONENT_SHOOTING": {
                return Phases.OPPONENT_SHOOTING;
            }
            case "OPPONENT_ATTACK": {
                return Phases.OPPONENT_ATTACK;
            }
            case "OPPONENT_COMBAT": {
                return Phases.OPPONENT_COMBAT;
            }
            case "OPPONENT_MORALE": {
                return Phases.OPPONENT_MORALE;
            }
            case "ANYTIME": {
                return Phases.ANYTIME;
            }
            case "SLAIN_MODEL": {
                return Phases.SLAIN_MODEL;
            }
            case "DEALT_DAMAGE": {
                return Phases.DEALT_DAMAGE;
            }
        }
        return Phases.ANYTIME;
    }
}
