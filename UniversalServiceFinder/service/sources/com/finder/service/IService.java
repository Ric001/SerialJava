package com.finder.service;

import javax.swing.JPanel;
import java.io.Serializable;

public interface Service extends Serializable {
    public JPanel getGuiPanel();
}