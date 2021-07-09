package com.gildedrose;

import org.approvaltests.reporters.GenericDiffReporter;

import java.text.MessageFormat;

public class MyIntellijReporter extends GenericDiffReporter {
    public static final String DIFF_PROGRAM = System.getenv("INTELLIJ_HOME") + "\\idea64.exe";
    public static final String DIFF_ARGUMENTS = "diff %s %s";
    public static final String PROGRAM_NOT_FOUND_MESSAGE = MessageFormat.format(
            "Unable to find IntelliJ at {0}", DIFF_PROGRAM);

    public MyIntellijReporter() {
        this(DIFF_PROGRAM, DIFF_ARGUMENTS, PROGRAM_NOT_FOUND_MESSAGE);
    }

    public MyIntellijReporter(String diffProgram, String diffArguments, String programNotFoundMessage) {
        super(diffProgram, diffArguments, programNotFoundMessage, GenericDiffReporter.TEXT_FILE_EXTENSIONS);
    }
}
