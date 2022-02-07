package ru.levelp.at.lesson03.maven.unit.test.groups;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("ru.levelp.at.lesson03.maven.unit.test.groups")
@IncludeTags("positive")
public class PositiveTestSuite {
}
