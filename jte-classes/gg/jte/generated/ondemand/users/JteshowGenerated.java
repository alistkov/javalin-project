package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UserPage;
@SuppressWarnings("unchecked")
public final class JteshowGenerated {
	public static final String JTE_NAME = "users/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,5,5,5,5,5,5,5,8,8,8,9,9,9,10,10,10,13,13,13,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UserPage page) {
		jteOutput.writeContent("\n<html>\n<head>\n    <title>User ");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(page.getUser().getFirstName());
		jteOutput.writeContent(" ");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(page.getUser().getLastName());
		jteOutput.writeContent("</title>\n</head>\n<body>\n<div><b>Name: </b> ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getUser().getFirstName());
		jteOutput.writeContent("</div>\n<div><b>Last name: </b> ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getUser().getLastName());
		jteOutput.writeContent("</div>\n<div><b>Email: </b> ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getUser().getEmail());
		jteOutput.writeContent("</div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UserPage page = (UserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
