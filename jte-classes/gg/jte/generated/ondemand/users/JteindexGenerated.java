package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,9,9,9,11,11,19,19,21,21,21,22,22,22,23,23,23,24,24,24,24,26,26,28,28,30,30,30,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n<html>\n<head>\n    <title>Users</title>\n</head>\n<body>\n<h1>Users page</h1>\n");
		if (page.getUsers().isEmpty()) {
			jteOutput.writeContent("\n    <p>Пока не добавлено ни одного курса</p>\n");
		} else {
			jteOutput.writeContent("\n    <table>\n        <tr>\n            <th>Name</th>\n            <th>Last name</th>\n            <th>Email</th>\n            <th>Link</th>\n        </tr>\n        ");
			for (var user : page.getUsers()) {
				jteOutput.writeContent("\n            <tr>\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getFirstName());
				jteOutput.writeContent("</td>\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getLastName());
				jteOutput.writeContent("</td>\n                <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(user.getEmail());
				jteOutput.writeContent("</td>\n                <td><a href=\"/users/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(user.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">Details</a></td>\n            </tr>\n        ");
			}
			jteOutput.writeContent("\n    </table>\n");
		}
		jteOutput.writeContent("\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
