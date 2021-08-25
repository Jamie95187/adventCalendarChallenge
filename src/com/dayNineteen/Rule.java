package com.dayNineteen;

public class Rule {

    public String left;
    public String right = "";

    public Rule(String leftRule) {
        this.left = leftRule;
    }

    public void setLeftRule(String leftRule) {
        this.left = leftRule;
    }

    public void setRightRule(String rightRule) {
        this.right = rightRule;
    }

}
