package runner;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Setter
@Getter
public class TimerTick implements ActionListener {

    private Timer timer;
    private int countdown;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<JLabel> statusLabelList;
    private static final String STATUS_LABEL_CAPTION_GAP = "                                ";

    public TimerTick(List<JLabel> statusLabelList){
        this.statusLabelList = statusLabelList;
    }

    //Setting time remaining in all Labels on all Tabs
    public void actionPerformed(ActionEvent e) {
        countdown--;
        showTextOnAllLabels(String.format("Wait time %s",countdown));
        if (countdown == 0) {
            timer.stop();
            showTextOnAllLabels("Start Script");
        }
    }

    //method for displaying exception to failed script execution on all tabs
    public void showError() {
        timer.stop();
        showTextOnAllLabels("Script starting failed. Try again");
    }

    //Private method to setting text on all tabs
    private void showTextOnAllLabels(String text) {
        statusLabelList.forEach(jLabel ->
                jLabel.setText(String.format("%s%s%s", STATUS_LABEL_CAPTION_GAP, text, STATUS_LABEL_CAPTION_GAP)));
    }
}
