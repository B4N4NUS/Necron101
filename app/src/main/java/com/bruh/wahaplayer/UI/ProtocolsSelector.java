package com.bruh.wahaplayer.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bruh.wahaplayer.Parser;
import com.bruh.wahaplayer.R;
import com.bruh.wahaplayer.phases.Phases;
import com.bruh.wahaplayer.protocols.Protocol;

public class ProtocolsSelector extends Fragment {
    private LinearLayout layout;
    private int currentProtocol = 1;
    private boolean[] avaliable = {true, true, true, true, true, true};
    private ProtocolInfo[] protocols;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.protocol_selector, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        layout = view.findViewById(R.id.protocol_content);
        layout.removeAllViews();

        Protocol dummy = new Protocol();
        dummy.header = "Protocol of the Eternal Guardian";
        dummy.description = "Temporary dimensional shielding flickers into being around the Necrons as they stand tall upon the battlefield like graven statues." +
                "\n\nDirective 1: \nEach time an attack is made against this unit, if it did not make a Normal Move, Advance or Fall Back this battle round, this unit receives the benefit of Light Cover" +
                "\n\nDirective 2: \nEach time an enemy unit declares a charge against this unit, if this unit is not within Engagement Range of any enemy units, it can either Hold Steady or Set to Defend." +
                "\n\nIf it Holds Steady, then until the end of the phase, any Overwatch attacks made by models in that unit score hits on unmodified rolls of 5+, instead of 6." +
                "\nIf it Sets to Defend, then until the end of the phase, it cannot fire Overwatch, but until the end of the next Fight phase, each time a model in that unit makes a melee attack, add 1 to that attacks hit roll.";
        dummy.order = -1;
        Parser.protocols.add(dummy);
        dummy = new Protocol();
        dummy.header = "Protocol of the Sudden Storm";
        dummy.description = "Temporary dimensional shielding flickers into being around the Necrons as they stand tall upon the battlefield like graven statues." +
                "\n\nDirective 1: \nEach time an attack is made against this unit, if it did not make a Normal Move, Advance or Fall Back this battle round, this unit receives the benefit of Light Cover" +
                "\n\nDirective 2: \nEach time an enemy unit declares a charge against this unit, if this unit is not within Engagement Range of any enemy units, it can either Hold Steady or Set to Defend." +
                "\nIf it Holds Steady, then until the end of the phase, any Overwatch attacks made by models in that unit score hits on unmodified rolls of 5+, instead of 6." +
                "\nIf it Sets to Defend, then until the end of the phase, it cannot fire Overwatch, but until the end of the next Fight phase, each time a model in that unit makes a melee attack, add 1 to that attacks hit roll.";
        dummy.order = -1;
        Parser.protocols.add(dummy);
        dummy = new Protocol();
        dummy.header = "Protocol of the Vengeful Stars";
        dummy.description = "Criss-cross fire leaps from the Necron ranks, forming a blazing corona of deadly energy from which there can be no escape." +
                "\n\nDirective 1: \nEach time a model in this unit makes a ranged attack, on an unmodified wound roll of 6, improve the Armour Penetration characteristic of that attack by 1." +
                "\n\nDirective 2: \nEach time a model in this unit makes a ranged attack that targets a unit within half range, the target does not receive the benefits of cover to its saving throw against that attack." +
                "\nAt the start of each battle round, if any NECRONS CHARACTER units from your army are on the battlefield, the command protocol that you assigned to that battle round becomes active for your army until the end of that battle round. Each command protocol is made up of two directives. When a command protocol becomes active for your army, reveal it to your opponent and select one of its directives. Until the assigned command protocol stops being active, while a unit that is eligible to benefit from this ability is on the battlefield, that unit benefits from the selected directive.\n" +
                "\nIn addition, if all units from your army are from the same dynasty (excluding DYNASTIC AGENT, C’TAN SHARD and UNALIGNED units), select one command protocol that has not been assigned to a battle round (there will typically only be one). That command protocol is active in every battle round in addition to the one assigned to that battle round – select which directive your units will benefit from at the start of each battle round. Note that if this additional command protocol is the one described in your dynasty’s code, this means both of its directives apply to all units with this ability in your army in every battle round, in addition to the protocol assigned to that battle round. The available command protocols are shown below.\n" +
                "\nDesigner’s Note: Some rules refer to ‘the active command protocol’, in these instances these rules refer to all command protocols that are active for your army.";
        dummy.order = -1;
        Parser.protocols.add(dummy);
        dummy = new Protocol();
        dummy.header = "Protocol of the Hungry Void";
        dummy.description = "The Necrons strike with data-augmented accuracy, their murderous attacks as inescapable as the killing cold of space." +
                "\n\nDirective 1: \nEach time a model in this unit makes a melee attack, on an unmodified wound roll of 6, improve the Armour Penetration characteristic of that attack by 1." +
                "\n\nDirective 2: \nEach time a model in this unit makes a melee attack, if this unit made a charge move, was charged or performed a Heroic Intervention this turn, add 1 to that attacks Strength characteristic.";
        dummy.order = -1;
        Parser.protocols.add(dummy);
        dummy = new Protocol();
        dummy.header = "Protocol of the Undying Legions";
        dummy.description = "At a hissing static signal, nanoscarabs are released in boiling black clouds that whirl about the legions and effect constant repairs." +
                "\n\nDirective 1: \nEach time this unit uses its Living Metal ability, each model in this unit regains 1 additional lost wound." +
                "\n\nDirective 2: \nEach time you make Reanimation Protocol rolls for this unit, you can re-roll one of the dice.";
        dummy.order = -1;
        Parser.protocols.add(dummy);
        dummy = new Protocol();
        dummy.header = "Protocol of the Conquering Tyrant";
        dummy.description = "The legions employ the strategies of their masters in perfect synchronicity, laying down hails of mechanically coordinated fire." +
                "\n\nDirective 1: \nAdd 3\" to the range of this unit’s aura abilities (to a maximum of 12\") and increase the range of the following abilities this unit has by 3\" (to a maximum of 12\"): Lord’s Will; My Will Be Done; Rites of Reanimation." +
                "\n\nDirective 2: \nThis unit is eligible to shoot in a turn in which it Fell Back, but if it does, then until the end of the turn, each time a model in this unit makes a ranged attack, subtract 1 from that attack’s hit roll.";
        dummy.order = -1;
        Parser.protocols.add(dummy);



        protocols = new ProtocolInfo[6];
        protocols[0] = new ProtocolInfo(getContext(), "Protocol of the Eternal Guardian",
                "Temporary dimensional shielding flickers into being around the Necrons as they stand tall upon the battlefield like graven statues." +
                        "\n\nDirective 1: \nEach time an attack is made against this unit, if it did not make a Normal Move, Advance or Fall Back this battle round, this unit receives the benefit of Light Cover" +
                        "\n\nDirective 2: \nEach time an enemy unit declares a charge against this unit, if this unit is not within Engagement Range of any enemy units, it can either Hold Steady or Set to Defend." +
                        "\nIf it Holds Steady, then until the end of the phase, any Overwatch attacks made by models in that unit score hits on unmodified rolls of 5+, instead of 6." +
                        "\nIf it Sets to Defend, then until the end of the phase, it cannot fire Overwatch, but until the end of the next Fight phase, each time a model in that unit makes a melee attack, add 1 to that attacks hit roll.");
        protocols[1] = new ProtocolInfo(getContext(), "Protocol of the Sudden Storm",
                "Arcing energies leap from one Necron unit to the next, lending speed to their limbs and causing their eye lenses to blaze." +
                        "\n\nDirective 1: \nAdd 1\" to the Move characteristic of models in this unit." +
                        "\n\nDirective 2: \nIf this unit is performing an action, it can still make attacks with ranged weapons without that action failing.");
        protocols[2] = new ProtocolInfo(getContext(), "Protocol of the Vengeful Stars",
                "Criss-cross fire leaps from the Necron ranks, forming a blazing corona of deadly energy from which there can be no escape." +
                        "\n\nDirective 1: \nEach time a model in this unit makes a ranged attack, on an unmodified wound roll of 6, improve the Armour Penetration characteristic of that attack by 1." +
                        "\n\nDirective 2: \nEach time a model in this unit makes a ranged attack that targets a unit within half range, the target does not receive the benefits of cover to its saving throw against that attack." +
                        "\nAt the start of each battle round, if any NECRONS CHARACTER units from your army are on the battlefield, the command protocol that you assigned to that battle round becomes active for your army until the end of that battle round. Each command protocol is made up of two directives. When a command protocol becomes active for your army, reveal it to your opponent and select one of its directives. Until the assigned command protocol stops being active, while a unit that is eligible to benefit from this ability is on the battlefield, that unit benefits from the selected directive.\n" +
                        "\n" +
                        "In addition, if all units from your army are from the same dynasty (excluding DYNASTIC AGENT, C’TAN SHARD and UNALIGNED units), select one command protocol that has not been assigned to a battle round (there will typically only be one). That command protocol is active in every battle round in addition to the one assigned to that battle round – select which directive your units will benefit from at the start of each battle round. Note that if this additional command protocol is the one described in your dynasty’s code, this means both of its directives apply to all units with this ability in your army in every battle round, in addition to the protocol assigned to that battle round. The available command protocols are shown below.\n" +
                        "\n" +
                        "Designer’s Note: Some rules refer to ‘the active command protocol’, in these instances these rules refer to all command protocols that are active for your army.");
        protocols[3] = new ProtocolInfo(getContext(), "Protocol of the Hungry Void",
                "The Necrons strike with data-augmented accuracy, their murderous attacks as inescapable as the killing cold of space." +
                        "\n\nDirective 1: \nEach time a model in this unit makes a melee attack, on an unmodified wound roll of 6, improve the Armour Penetration characteristic of that attack by 1." +
                        "\n\nDirective 2: \nEach time a model in this unit makes a melee attack, if this unit made a charge move, was charged or performed a Heroic Intervention this turn, add 1 to that attacks Strength characteristic.");
        protocols[4] = new ProtocolInfo(getContext(), "Protocol of the Undying Legions",
                "At a hissing static signal, nanoscarabs are released in boiling black clouds that whirl about the legions and effect constant repairs." +
                        "\n\nDirective 1: \nEach time this unit uses its Living Metal ability, each model in this unit regains 1 additional lost wound." +
                        "\n\nDirective 2: \nEach time you make Reanimation Protocol rolls for this unit, you can re-roll one of the dice.");
        protocols[5] = new ProtocolInfo(getContext(), "Protocol of the Conquering Tyrant",
                "The legions employ the strategies of their masters in perfect synchronicity, laying down hails of mechanically coordinated fire." +
                        "\n\nDirective 1: \nAdd 3\" to the range of this unit’s aura abilities (to a maximum of 12\") and increase the range of the following abilities this unit has by 3\" (to a maximum of 12\"): Lord’s Will; My Will Be Done; Rites of Reanimation." +
                        "\n\nDirective 2: \nThis unit is eligible to shoot in a turn in which it Fell Back, but if it does, then until the end of the turn, each time a model in this unit makes a ranged attack, subtract 1 from that attack’s hit roll.");

        for (int i = 0; i < 6; i++) {
            layout.addView(protocols[i]);
            int finalI = i;
            protocols[i].order.setOnClickListener(e -> {
                if (protocols[finalI].order != null) {
                    if (!protocols[finalI].order.getText().toString().equals(" ")) {
                        if (currentProtocol > Integer.parseInt(protocols[finalI].order.getText().toString())) {
                            currentProtocol = Integer.parseInt(protocols[finalI].order.getText().toString());
                        }
                        protocols[finalI].order.setText(" ");
                        protocols[finalI].text.setTextColor(getResources().getColor(R.color.light_green));
                        for (int j = 0; j < protocols.length; j++) {
                            if (!protocols[j].order.getText().toString().equals(" ") && Integer.parseInt(protocols[j].order.getText().toString()) - currentProtocol > 0) {
                                protocols[j].order.setText(" ");
                                protocols[j].text.setTextColor(getResources().getColor(R.color.light_green));
                            }
                        }
                    } else {
                        if (currentProtocol <= 5) {
                            protocols[finalI].order.setText(currentProtocol++ + "");
                            protocols[finalI].text.setTextColor(getResources().getColor(R.color.green));
                            for (int j = 0; j < protocols.length; j++) {
                                if (!protocols[j].order.getText().toString().equals(" ") && Integer.parseInt(protocols[j].order.getText().toString()) - currentProtocol > 0) {
                                    protocols[j].order.setText(" ");
                                    protocols[j].text.setTextColor(getResources().getColor(R.color.light_green));
                                }
                            }
                        }
                    }

                    for(int j = 0; j < 6; j++) {
                        if (!protocols[j].order.getText().toString().equals(" ")) {
                            Parser.protocols.get(j).order = Integer.parseInt(protocols[j].order.getText().toString());
                        } else {
                            Parser.protocols.get(j).order = -1;
                        }
                        System.out.println(Parser.protocols.get(j).header + " "+ Parser.protocols.get(j).order);
                    }
                    System.out.println(" \n");
                    System.out.println("TOUCHED " + currentProtocol);
                }
            });
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (layout != null && isVisibleToUser) {
            final int childCount = layout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Typewriter v = ((ProtocolInfo) layout.getChildAt(i)).text;
                v.animateText();
            }
        }
    }
}
