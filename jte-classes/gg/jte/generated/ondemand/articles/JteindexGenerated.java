package gg.jte.generated.ondemand.articles;
import org.example.hexlet.dto.articles.ArticlesPage;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "articles/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,3,3,5,5,16,16,19,19,19,22,22,22,25,25,25,28,28,32,32,32,32,32,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, ArticlesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Articles list</h1>\n    <div class=\"mx-auto p-4 py-md-5\">\n        <main>\n            <h1>All articles</h1>\n\n            <div class=\"mb-3\">\n                <a href=\"/articles/build\">Create new article</a>\n            </div>\n\n            <table class=\"table table-striped\">\n                ");
				for (var article : page.getArticles()) {
					jteOutput.writeContent("\n                    <tr>\n                        <td>\n                            ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(article.getId());
					jteOutput.writeContent("\n                        </td>\n                        <td>\n                            ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(article.getTitle());
					jteOutput.writeContent("\n                        </td>\n                        <td>\n                            ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(article.getContent());
					jteOutput.writeContent("\n                        </td>\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n            </table>\n        </main>\n    </div>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		ArticlesPage page = (ArticlesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
