import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.nio.file.Path;
import java.nio.file.FileSystems;

public class Main {
	public static void main(String[] args) throws Exception {
		Path path = FileSystems.getDefault().getPath("test.mu");
		SQLLexer lexer = new SQLLexer(CharStreams.fromPath(path));
		SQLParser parser = new SQLParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.parse();

		SQLSemanticVisitor visitor = new SQLSemanticVisitor();
		visitor.visitSelect_statement(parser.);
}
