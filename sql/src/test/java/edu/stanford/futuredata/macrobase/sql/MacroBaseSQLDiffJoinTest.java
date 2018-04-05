package edu.stanford.futuredata.macrobase.sql;

import static edu.stanford.futuredata.macrobase.sql.SQLTestUtils.loadDataFrameFromCSV;
import static edu.stanford.futuredata.macrobase.sql.SQLTestUtils.runQueriesFromFile;

import com.google.common.collect.ImmutableMap;
import edu.stanford.futuredata.macrobase.datamodel.Schema.ColType;
import edu.stanford.futuredata.macrobase.sql.parser.SqlParser;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class MacroBaseSQLDiffJoinTest {

    private SqlParser parser;
    private QueryEngine queryEngine;


    private final Map<String, ColType> ONE_ATTR_SCHEMA = ImmutableMap.<String, ColType>builder()
        .put("state", ColType.STRING)
        .put("support", ColType.DOUBLE)
        .put("global_ratio", ColType.DOUBLE)
        .put("outlier_count", ColType.DOUBLE)
        .put("total_count", ColType.DOUBLE)
        .build();

    private final Map<String, ColType> TWO_ATTRS_SCHEMA = ImmutableMap.<String, ColType>builder()
        .put("app", ColType.STRING)
        .put("state", ColType.STRING)
        .put("support", ColType.DOUBLE)
        .put("global_ratio", ColType.DOUBLE)
        .put("outlier_count", ColType.DOUBLE)
        .put("total_count", ColType.DOUBLE)
        .build();

    private final Map<String, ColType> FOUR_ATTRS_SCHEMA = ImmutableMap.<String, ColType>builder()
        .put("A1", ColType.STRING)
        .put("A2", ColType.STRING)
        .put("A3", ColType.STRING)
        .put("A4", ColType.STRING)
        .put("support", ColType.DOUBLE)
        .put("global_ratio", ColType.DOUBLE)
        .put("outlier_count", ColType.DOUBLE)
        .put("total_count", ColType.DOUBLE)
        .build();

    @Before
    public void setUp() throws Exception {
        queryEngine = new QueryEngine();
        parser = new SqlParser();
    }

    @Test
    public void diffJoinQuery1() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/1.sql",
            loadDataFrameFromCSV("diff-joins/1.csv", ONE_ATTR_SCHEMA));
    }

    @Test
    public void diffJoinQuery2() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/2.sql",
            loadDataFrameFromCSV("diff-joins/2.csv", ONE_ATTR_SCHEMA));
    }

    @Test
    public void diffJoinQuery3() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/3.sql",
            loadDataFrameFromCSV("diff-joins/3.csv", ONE_ATTR_SCHEMA));
    }

    @Test
    public void diffJoinQuery4() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/4.sql",
            loadDataFrameFromCSV("diff-joins/4.csv", ONE_ATTR_SCHEMA));
    }

    @Test
    public void diffJoinQuery5() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/5.sql",
            loadDataFrameFromCSV("diff-joins/5.csv", TWO_ATTRS_SCHEMA));
    }

    @Test
    public void diffJoinQuery6() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/6.sql",
            loadDataFrameFromCSV("diff-joins/6.csv", TWO_ATTRS_SCHEMA));
    }

    @Test
    public void diffJoinQuery7() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/7.sql",
            loadDataFrameFromCSV("diff-joins/7.csv", TWO_ATTRS_SCHEMA));
    }

    @Test
    public void diffJoinQuery8() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/8.sql",
            loadDataFrameFromCSV("diff-joins/8.csv", TWO_ATTRS_SCHEMA));
    }

    @Test
    public void diffJoinQuery9() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/9.sql",
            loadDataFrameFromCSV("diff-joins/9.csv", FOUR_ATTRS_SCHEMA));
    }

    @Test
    public void diffJoinQuery10() throws Exception {
        runQueriesFromFile(parser, queryEngine, "diff-joins/10.sql",
            loadDataFrameFromCSV("diff-joins/10.csv", FOUR_ATTRS_SCHEMA));
    }
}
