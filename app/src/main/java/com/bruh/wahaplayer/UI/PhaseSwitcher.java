package com.bruh.wahaplayer.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bruh.wahaplayer.Parser;
import com.bruh.wahaplayer.R;
import com.bruh.wahaplayer.phases.Phases;

import java.util.Objects;

public class PhaseSwitcher extends Fragment {

    private String[] names = {
            "Deployment",
            "Command",
            "Movement",
            "Psycker",
            "Shooting",
            "Attack",
            "Combat",
            "Morale",
            "Opponent Command",
            "Opponent Movement",
            "Opponent Psycker",
            "Oppponent Shooting",
            "Opponent Attack",
            "Opponent Combat",
            "Opponent Morale"
    };
    private int cycles = 0;
    private int current = 0;

    private LinearLayout layout;
    private Button prev, next;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.phase_switcher, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        layout = view.findViewById(R.id.phase_content);
        layout.removeAllViews();

        prev = view.findViewById(R.id.phase_prev);
        next = view.findViewById(R.id.phase_next);
        TextView name = view.findViewById(R.id.phase_name);

        prev.setOnClickListener(e -> {
            getPrev();
            name.setText(names[current]);
            updateRules();
        });
        next.setOnClickListener(e -> {
            getNext();
            name.setText(names[current]);
            updateRules();
        });
        name.setText("Deployment");
        prev.setText(names[current].charAt(0)+"");
        next.setText(names[(current +1)% names.length].charAt(0)+"");
    }

    private void updateRules() {
        layout.removeAllViews();
        Phases currentPhase = Phases.ANYTIME;
        switch (current) {
            case 0: {
                currentPhase = Phases.DEPLOYMENT;
                break;
            }
            case 1: {
                currentPhase = Phases.COMMAND;
                break;
            }
            case 2: {
                currentPhase = Phases.MOVEMENT;
                break;
            }
            case 3: {
                currentPhase = Phases.PSYCKER;
                break;
            }
            case 4: {
                currentPhase = Phases.SHOOTING;
                break;
            }
            case 5: {
                currentPhase = Phases.ATTACK;
                break;
            }
            case 6: {
                currentPhase = Phases.COMBAT;
                break;
            }
            case 7: {
                currentPhase = Phases.MORALE;
                break;
            }
            case 8: {
                currentPhase = Phases.OPPONENT_COMMAND;
                break;
            }
            case 9: {
                currentPhase = Phases.OPPONENT_MOVEMENT;
                break;
            }
            case 10: {
                currentPhase = Phases.OPPONENT_PSYCKER;
                break;
            }
            case 11: {
                currentPhase = Phases.OPPONENT_SHOOTING;
                break;
            }
            case 12: {
                currentPhase = Phases.OPPONENT_ATTACK;
                break;
            }
            case 13: {
                currentPhase = Phases.OPPONENT_COMBAT;
                break;
            }
            case 14: {
                currentPhase = Phases.OPPONENT_MORALE;
                break;
            }
        }
        System.out.println("CURRENT " + current + " PHASE " + currentPhase);
        AbilityInfo dummyAbility;
        for (int i = 0; i < Parser.rules.size(); i++) {
            if (Parser.rules.get(i).phase == currentPhase ||
                    Parser.rules.get(i).phase == Phases.ANYTIME ||
                    current > 10 && current < 14 && Parser.rules.get(i).phase == Phases.SLAIN_MODEL ||
                    (current == 4 || current == 6 || current == 3 || current == 13) && Parser.rules.get(i).phase == Phases.DEALT_DAMAGE) {
                if (Parser.rules.get(i).name.equals("Command Protocols")) {
                    System.out.println("COMMAND PROTOCOLS FOUND");
                    for(int j = 0; j < 6; j++) {
                        if (cycles % 5 + 1 == Parser.protocols.get(j).order) {
                            Objects.requireNonNull(Parser.getRules.get("Command Protocols")).description = Parser.protocols.get(j).header + "\n\n" +Parser.protocols.get(j).description;
                            System.out.println("ALTERED COMMAND PROTOCOLS TO: " + Parser.protocols.get(j).header);
                        }
                    }
                    if (Objects.requireNonNull(Parser.getRules.get("Command Protocols")).description.equals("BRUH")) {
                        continue;
                    }
                }
                dummyAbility = new AbilityInfo(getContext(), Parser.rules.get(i));
                if (dummyAbility.visible) {
                    layout.addView(dummyAbility);
                }
                System.out.println("FOUND " + Parser.rules.get(i).name);
            }
        }
        prev.setText(names[current].charAt(0)+"");
        next.setText(names[(current +1)% names.length].charAt(0)+"");
        TextView end = new TextView(getContext());
        end.setTextColor(getResources().getColor(R.color.black));
        end.setTextSize(80);
        layout.addView(end);

    }

    private void getPrev() {
        current--;
        if (current <= 0) {
            if (cycles == 0) {
                current = 0;
            } else {
                current = names.length - 1;
                cycles--;
            }
        }
    }

    private void getNext() {
        current++;
        if (current >= names.length) {
            current = 1;
            cycles++;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (layout != null && isVisibleToUser) {
            updateRules();
        }
    }
}
