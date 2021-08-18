package cdm.legalagreement.master;

import cdm.legalagreement.master.meta.CreditSupportDocumentMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identification of party specific Credit Support Documents applicable to the document.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditSupportDocument extends RosettaModelObject {
	CreditSupportDocument build();
	CreditSupportDocument.CreditSupportDocumentBuilder toBuilder();
	
	/**
	 * The party election of Credit Support Document(s), if any.
	 */
	List<? extends CreditSupportDocumentElection> getCreditSupportDocumentElection();
	final static CreditSupportDocumentMeta metaData = new CreditSupportDocumentMeta();
	
	@Override
	default RosettaMetaData<? extends CreditSupportDocument> metaData() {
		return metaData;
	} 
			
	static CreditSupportDocument.CreditSupportDocumentBuilder builder() {
		return new CreditSupportDocument.CreditSupportDocumentBuilderImpl();
	}
	
	default Class<? extends CreditSupportDocument> getType() {
		return CreditSupportDocument.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("creditSupportDocumentElection"), processor, CreditSupportDocumentElection.class, getCreditSupportDocumentElection());
	}
	
	
	interface CreditSupportDocumentBuilder extends CreditSupportDocument, RosettaModelObjectBuilder {
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder getOrCreateCreditSupportDocumentElection(int _index);
		List<? extends CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder> getCreditSupportDocumentElection();
		CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection creditSupportDocumentElection);
		CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection creditSupportDocumentElection, int _idx);
		CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElection);
		CreditSupportDocument.CreditSupportDocumentBuilder setCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("creditSupportDocumentElection"), processor, CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder.class, getCreditSupportDocumentElection());
		}
		
	}
	
	//CreditSupportDocument.CreditSupportDocumentImpl
	class CreditSupportDocumentImpl implements CreditSupportDocument {
		private final List<? extends CreditSupportDocumentElection> creditSupportDocumentElection;
		
		protected CreditSupportDocumentImpl(CreditSupportDocument.CreditSupportDocumentBuilder builder) {
			this.creditSupportDocumentElection = ofNullable(builder.getCreditSupportDocumentElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends CreditSupportDocumentElection> getCreditSupportDocumentElection() {
			return creditSupportDocumentElection;
		}
		
		@Override
		public CreditSupportDocument build() {
			return this;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder toBuilder() {
			CreditSupportDocument.CreditSupportDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportDocument.CreditSupportDocumentBuilder builder) {
			ofNullable(getCreditSupportDocumentElection()).ifPresent(builder::setCreditSupportDocumentElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditSupportDocumentElection, _that.getCreditSupportDocumentElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportDocumentElection != null ? creditSupportDocumentElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocument {" +
				"creditSupportDocumentElection=" + this.creditSupportDocumentElection +
			'}';
		}
	}
	
	//CreditSupportDocument.CreditSupportDocumentBuilderImpl
	class CreditSupportDocumentBuilderImpl implements CreditSupportDocument.CreditSupportDocumentBuilder {
	
		protected List<CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder> creditSupportDocumentElection = new ArrayList<>();
	
		public CreditSupportDocumentBuilderImpl() {
		}
	
		@Override
		public List<? extends CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder> getCreditSupportDocumentElection() {
			return creditSupportDocumentElection;
		}
		
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder getOrCreateCreditSupportDocumentElection(int _index) {
		
			if (creditSupportDocumentElection==null) {
				this.creditSupportDocumentElection = new ArrayList<>();
			}
			CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder result;
			return getIndex(creditSupportDocumentElection, _index, () -> {
						CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder newCreditSupportDocumentElection = CreditSupportDocumentElection.builder();
						return newCreditSupportDocumentElection;
					});
		}
		
	
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection creditSupportDocumentElection) {
			if (creditSupportDocumentElection!=null) this.creditSupportDocumentElection.add(creditSupportDocumentElection.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection creditSupportDocumentElection, int _idx) {
			getIndex(this.creditSupportDocumentElection, _idx, () -> creditSupportDocumentElection.toBuilder());
			return this;
		}
		@Override 
		public CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElections) {
			if (creditSupportDocumentElections != null) {
				for (CreditSupportDocumentElection toAdd : creditSupportDocumentElections) {
					this.creditSupportDocumentElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditSupportDocument.CreditSupportDocumentBuilder setCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElections) {
			if (creditSupportDocumentElections == null)  {
				this.creditSupportDocumentElection = new ArrayList<>();
			}
			else {
				this.creditSupportDocumentElection = creditSupportDocumentElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CreditSupportDocument build() {
			return new CreditSupportDocument.CreditSupportDocumentImpl(this);
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder prune() {
			creditSupportDocumentElection = creditSupportDocumentElection.stream().filter(b->b!=null).<CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditSupportDocumentElection()!=null && getCreditSupportDocumentElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportDocument.CreditSupportDocumentBuilder o = (CreditSupportDocument.CreditSupportDocumentBuilder) other;
			
			merger.mergeRosetta(getCreditSupportDocumentElection(), o.getCreditSupportDocumentElection(), this::getOrCreateCreditSupportDocumentElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditSupportDocumentElection, _that.getCreditSupportDocumentElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportDocumentElection != null ? creditSupportDocumentElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocumentBuilder {" +
				"creditSupportDocumentElection=" + this.creditSupportDocumentElection +
			'}';
		}
	}
}
