package gg.jte.generated.ondemand.articles;
import org.example.hexlet.dto.articles.BuildArticlePage;
@SuppressWarnings("unchecked")
public final class JtebuildGenerated {
	public static final String JTE_NAME = "articles/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,3,3,5,5,6,6,9,9,10,10,11,11,11,12,12,13,13,16,16,23,23,23,23,23,23,23,23,23,28,28,28,33,33,33,33,33,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildArticlePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n        <div class=\"mb-3\">\n            <ul>\n                ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                    ");
						for (var error : validator) {
							jteOutput.writeContent("\n                        <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                    ");
						}
						jteOutput.writeContent("\n                ");
					}
					jteOutput.writeContent("\n            </ul>\n        </div>\n    ");
				}
				jteOutput.writeContent("\n\n    <div class=\"mx-auto p-4 py-md-5\">\n        <form action=\"/articles\" method=\"post\">\n            <div class=\"mb-3\">\n                <label class=\"form-label\">\n                    Title\n                    <input type=\"text\" class=\"form-control\" name=\"title\"");
				var __jte_html_attribute_0 = page.getTitle();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n                </label>\n            </div>\n            <div class=\"mb-3\">\n                <label class=\"form-label\">Content</label>\n                <textarea class=\"form-control\" rows=\"20\" cols=\"70\" type=\"text\" name=\"content\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getContent());
				jteOutput.writeContent("</textarea>\n            </div>\n            <input type=\"submit\" class=\"btn btn-primary\" value=\"Submit\" />\n        </form>\n    </div>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildArticlePage page = (BuildArticlePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
