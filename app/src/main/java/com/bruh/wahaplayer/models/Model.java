package com.bruh.wahaplayer.models;

import androidx.annotation.NonNull;

import com.bruh.wahaplayer.Parser;
import com.bruh.wahaplayer.R;
import com.bruh.wahaplayer.rules.Rule;
import com.bruh.wahaplayer.weapons.Weapon;

import java.util.ArrayList;
import java.util.Objects;

public class Model {
    public String name;
    public String m,ws,bs,s,t,w,a,ld,save;
    public String[] weapons;
    public String[] rules;
    public boolean enabled = false;

    public Model() {
        name = m = ws = bs = s = t = a = w = ld = save = "";
        weapons = new String[0];
        rules = new String[0];
    }

    public void clean() {
        for(int i = 0; i < weapons.length; i++) {
            weapons[i] = weapons[i].replace("[", "").replace("]", "").replace("\"", "");
        }
        for(int i = 0; i < rules.length; i++) {
            rules[i] = rules[i].replace("[", "").replace("]", "").replace("\"", "");
            try {
                Objects.requireNonNull(Parser.getRules.get(rules[i])).models.add(name);
            } catch (Exception ex) {
                System.out.println("CANT FIND RULE: " + rules[i]);
                Parser.getRules.put(rules[i],new Rule());
            }
        }

    }

    @NonNull
    public String toString() {
        return name + " "+m + " "+ws + " "+bs + " "+s + " "+t + " "+w + " "+a + " "+ld + " "+save + "\n"+weapons[0] + "\n"+rules[0];
    }
}
