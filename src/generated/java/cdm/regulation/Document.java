package cdm.regulation;

import cdm.regulation.meta.DocumentMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface Document extends RosettaModelObject {
	Document build();
	Document.DocumentBuilder toBuilder();
	
	/**
	 */
	FinInstrmRptgTxRpt getFinInstrmRptgTxRpt();
	final static DocumentMeta metaData = new DocumentMeta();
	
	@Override
	default RosettaMetaData<? extends Document> metaData() {
		return metaData;
	} 
			
	static Document.DocumentBuilder builder() {
		return new Document.DocumentBuilderImpl();
	}
	
	default Class<? extends Document> getType() {
		return Document.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("finInstrmRptgTxRpt"), processor, FinInstrmRptgTxRpt.class, getFinInstrmRptgTxRpt());
	}
	
	
	interface DocumentBuilder extends Document, RosettaModelObjectBuilder {
		FinInstrmRptgTxRpt.FinInstrmRptgTxRptBuilder getOrCreateFinInstrmRptgTxRpt();
		FinInstrmRptgTxRpt.FinInstrmRptgTxRptBuilder getFinInstrmRptgTxRpt();
		Document.DocumentBuilder setFinInstrmRptgTxRpt(FinInstrmRptgTxRpt finInstrmRptgTxRpt);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("finInstrmRptgTxRpt"), processor, FinInstrmRptgTxRpt.FinInstrmRptgTxRptBuilder.class, getFinInstrmRptgTxRpt());
		}
		
	}
	
	//Document.DocumentImpl
	class DocumentImpl implements Document {
		private final FinInstrmRptgTxRpt finInstrmRptgTxRpt;
		
		protected DocumentImpl(Document.DocumentBuilder builder) {
			this.finInstrmRptgTxRpt = ofNullable(builder.getFinInstrmRptgTxRpt()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FinInstrmRptgTxRpt getFinInstrmRptgTxRpt() {
			return finInstrmRptgTxRpt;
		}
		
		@Override
		public Document build() {
			return this;
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			Document.DocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Document.DocumentBuilder builder) {
			ofNullable(getFinInstrmRptgTxRpt()).ifPresent(builder::setFinInstrmRptgTxRpt);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(finInstrmRptgTxRpt, _that.getFinInstrmRptgTxRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finInstrmRptgTxRpt != null ? finInstrmRptgTxRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Document {" +
				"finInstrmRptgTxRpt=" + this.finInstrmRptgTxRpt +
			'}';
		}
	}
	
	//Document.DocumentBuilderImpl
	class DocumentBuilderImpl implements Document.DocumentBuilder {
	
		protected FinInstrmRptgTxRpt.FinInstrmRptgTxRptBuilder finInstrmRptgTxRpt;
	
		public DocumentBuilderImpl() {
		}
	
		@Override
		public FinInstrmRptgTxRpt.FinInstrmRptgTxRptBuilder getFinInstrmRptgTxRpt() {
			return finInstrmRptgTxRpt;
		}
		
		@Override
		public FinInstrmRptgTxRpt.FinInstrmRptgTxRptBuilder getOrCreateFinInstrmRptgTxRpt() {
			FinInstrmRptgTxRpt.FinInstrmRptgTxRptBuilder result;
			if (finInstrmRptgTxRpt!=null) {
				result = finInstrmRptgTxRpt;
			}
			else {
				result = finInstrmRptgTxRpt = FinInstrmRptgTxRpt.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Document.DocumentBuilder setFinInstrmRptgTxRpt(FinInstrmRptgTxRpt finInstrmRptgTxRpt) {
			this.finInstrmRptgTxRpt = finInstrmRptgTxRpt==null?null:finInstrmRptgTxRpt.toBuilder();
			return this;
		}
		
		@Override
		public Document build() {
			return new Document.DocumentImpl(this);
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder prune() {
			if (finInstrmRptgTxRpt!=null && !finInstrmRptgTxRpt.prune().hasData()) finInstrmRptgTxRpt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFinInstrmRptgTxRpt()!=null && getFinInstrmRptgTxRpt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Document.DocumentBuilder o = (Document.DocumentBuilder) other;
			
			merger.mergeRosetta(getFinInstrmRptgTxRpt(), o.getFinInstrmRptgTxRpt(), this::setFinInstrmRptgTxRpt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(finInstrmRptgTxRpt, _that.getFinInstrmRptgTxRpt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finInstrmRptgTxRpt != null ? finInstrmRptgTxRpt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentBuilder {" +
				"finInstrmRptgTxRpt=" + this.finInstrmRptgTxRpt +
			'}';
		}
	}
}
